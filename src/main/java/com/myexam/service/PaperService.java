package com.myexam.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.myexam.DTO.PaperResultDTO;
import com.myexam.DTO.PublishInfoDTO;
import com.myexam.json.Question;
import com.myexam.json.StudentAnswer;
import com.myexam.mapper.MetaPaperMapper;
import com.myexam.mapper.RoomStudentMergeMapper;
import com.myexam.mapper.StudentPaperMapper;
import com.myexam.mapper.TeacherPaperMapper;
import com.myexam.mservice.MStudentPaperService;
import com.myexam.mservice.MTeacherPaperService;
import com.myexam.po.MetaPaper;
import com.myexam.po.RoomStudentMerge;
import com.myexam.po.StudentPaper;
import com.myexam.po.TeacherPaper;
import com.myexam.vo.StudentPaperVO;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

import java.beans.Transient;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PaperService {
    @Resource
    StudentPaperMapper studentPaperMapper;
    @Resource
    TeacherPaperMapper teacherPaperMapper;
    @Resource
    MTeacherPaperService mTeacherPaperService;
    @Resource
    MStudentPaperService mStudentPaperService;
    @Resource
    MetaPaperMapper metaPaperMapper;
    @Resource
    RoomStudentMergeMapper roomStudentMergeMapper;

    public void tempSave (PaperResultDTO paperResultDTO){
        String studentPaperId = paperResultDTO.getStudentPaperId();
        List<Object> studentAnswers = paperResultDTO.getAnswers();
        // 用于落库的json对象
        List<StudentAnswer> studentAnswerList = studentAnswers.stream().map((a) -> new StudentAnswer(0,a)).collect(Collectors.toList());
        // 更新学生端数据
        StudentPaper studentPaper = new StudentPaper()
                .setId(studentPaperId)
                .setStudentAnswers(JSON.toJSONString(studentAnswerList));
        studentPaperMapper.updateById(studentPaper);
    }

    @Transient
    public void submit(PaperResultDTO paperResultDTO){
        double obtainScore = 0;
        int correctNumber = 0;
        String studentPaperId = paperResultDTO.getStudentPaperId();
        List<Object> studentAnswers = paperResultDTO.getAnswers();
        int maxStudentAnswerLen = studentAnswers.size();
        String metaPaperId = paperResultDTO.getMetaPaperId();
        // 获取原题库题目（含答案和分数）
        MetaPaper metaPaper = metaPaperMapper.selectOne(new QueryWrapper<MetaPaper>().eq("id",metaPaperId));
        List<Question> questions = metaPaper.getQuestions();
        // 用于落库的json对象
        List<StudentAnswer> studentAnswerList = new ArrayList<>();
        // 比较答案，计算分数，更新对错标识
        for(int i=0;i<questions.size();i++){
            Question question = questions.get(i);
            Object correctAnswer = question.getCorrectAnswer();
            Object studentAnswer = null;
            if(i<maxStudentAnswerLen){
                studentAnswer = studentAnswers.get(i);
            }
            boolean isCorrect = correctAnswer.equals(studentAnswer);
            if(isCorrect){
                correctNumber++;
                obtainScore += question.getScore();
            }
            StudentAnswer studentAnswerObj = new StudentAnswer(isCorrect?1:2,studentAnswer);
            studentAnswerList.add(studentAnswerObj);
        }
        // 更新学生端数据
        StudentPaper studentPaper = new StudentPaper()
                .setId(studentPaperId)
                .setObtainScore(obtainScore)
                .setCorrectNumber(correctNumber)
                .setSubmitTime(LocalDateTime.now())
                .setFinishStatus(2)
                .setStudentAnswers(JSON.toJSONString(studentAnswerList));
        studentPaperMapper.updateById(studentPaper);
        // 更新教师端数据
        teacherPaperMapper.update(null,new UpdateWrapper<TeacherPaper>()
                .setSql("undone_number = undone_number -1")
                .setSql("done_number = done_number + 1").eq("id",paperResultDTO.getTeacherPaperId()));
    }

    public void startAnswering(String studentId,String paperId){
        StudentPaper studentPaper = new StudentPaper()
                .setStudentId(studentId)
                .setId(paperId)
                .setActualStartTime(LocalDateTime.now())
                .setFinishStatus(1);
        studentPaperMapper.updateById(studentPaper);
    }

    public List<StudentPaperVO> getUnDonePapers(String studentId){
        return studentPaperMapper.selectStudentPaperList(studentId,2,false);
    }

    /*
    用于检测未自动交卷
     */
    public void filterAutoCommitPaper(List<StudentPaperVO> list,boolean filter){
        Iterator<StudentPaperVO> iterator = list.iterator();
        while (iterator.hasNext()) {
            StudentPaperVO studentPaperVO = iterator.next();
            // 计算从开始答题到现在过去的秒数
            LocalDateTime before = studentPaperVO.getActualStartTime(), after = LocalDateTime.now();
            long spentTime = Duration.between(before, after).toMillis()/1000;
            // 如果已经消耗完考试时长，说明需要自动胶卷
            if(studentPaperVO.getFinishStatus()==1 && spentTime > studentPaperVO.getTotalTime()){
                PaperResultDTO paperResultDTO = new PaperResultDTO()
                        .setStudentPaperId(studentPaperVO.getId())
                        .setTeacherPaperId(studentPaperVO.getTeacherPaperId())
                        .setMetaPaperId(studentPaperVO.getMetaPaperId())
                        .setAnswers(studentPaperVO.getStudentAnswers().stream().map(StudentAnswer::getStudentAnswer).collect(Collectors.toList()));
                this.submit(paperResultDTO);
                if(filter){
                    iterator.remove();
                }
            }
        }
    }

    public List<MetaPaper> getMetaPapers(String teacherId){
        return metaPaperMapper.selectList(new QueryWrapper<MetaPaper>().eq("teacher_id",teacherId));
    }

    public MetaPaper getMetaPaper(String paperId){
        return metaPaperMapper.selectById(paperId);
    }

    public void deleteMetaPaper(String paperId){
        metaPaperMapper.deleteById(paperId);
    }
    public void updateMetaPaper(MetaPaper metaPaper){
        metaPaperMapper.updateById(metaPaper);
    }

    @Transactional
    public void publishPaper(PublishInfoDTO publishInfo) {
        List<String> roomIds = publishInfo.getRoomIds();
        // 批量更新教师端数据
        List<TeacherPaper> teacherPapers = new ArrayList<>();
        for(String roomId:roomIds){
            TeacherPaper teacherPaper = new TeacherPaper();
            BeanUtils.copyProperties(publishInfo,teacherPaper);
            teacherPaper.setRoomId(roomId);
            teacherPapers.add(teacherPaper);
        }
        mTeacherPaperService.saveBatch(teacherPapers);
        Map<String, String> roomId_teacherPaperId = teacherPapers
                .stream().collect(Collectors.toMap(TeacherPaper::getRoomId,TeacherPaper::getId
        ));
        // 查询所有room对应的学生
        List<RoomStudentMerge> roomStudentMerges = roomStudentMergeMapper
                .selectList(new QueryWrapper<RoomStudentMerge>().in("room_id",roomIds));
        List<StudentPaper> studentPapers = roomStudentMerges.stream().map(obj -> {
            String studentId = obj.getStudentId();
            String teacherPaperId = roomId_teacherPaperId.get(obj.getRoomId());
            StudentPaper studentPaper = new StudentPaper();
            BeanUtils.copyProperties(publishInfo,studentPaper);
            return studentPaper
                    .setStudentId(studentId)
                    .setRoomId(obj.getRoomId())
                    .setTeacherPaperId(teacherPaperId);
        }).collect(Collectors.toList());
        mStudentPaperService.saveBatch(studentPapers);
    }

    public int createMetaPaper(MetaPaper metaPaper){
        return metaPaperMapper.insert(metaPaper);
    }

    public List<StudentPaperVO> getDonePapers(String studentId){
        return studentPaperMapper.selectStudentPaperList(studentId,2,true);
    }

    public StudentPaperVO getPaperDetail(String paperId){
        return studentPaperMapper.selectStudentPaper(paperId);
    }
}
