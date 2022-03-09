package com.myexam.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.myexam.DTO.PaperResultDTO;
import com.myexam.json.Question;
import com.myexam.json.StudentAnswer;
import com.myexam.mapper.MetaPaperMapper;
import com.myexam.mapper.StudentPaperMapper;
import com.myexam.po.MetaPaper;
import com.myexam.po.StudentPaper;
import com.myexam.vo.StudentPaperVO;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PaperService {
    @Resource
    StudentPaperMapper studentPaperMapper;
    @Resource
    MetaPaperMapper metaPaperMapper;

    @Transient
    public void submit(PaperResultDTO paperResultDTO){
        double obtainScore = 0;
        int correctNumber = 0;
        String paperId = paperResultDTO.getPaperId();
        List<Object> studentAnswers = paperResultDTO.getAnswers();
        // 获取原题库题目（含答案和分数）
        MetaPaper metaPaper = metaPaperMapper.selectOne(new QueryWrapper<MetaPaper>().eq("id",paperId));
        List<Question> questions = JSON.parseArray(metaPaper.getQuestions(),Question.class);
        // 用于落库的json对象
        List<StudentAnswer> studentAnswerList = new ArrayList<>();
        // 比较答案，计算分数，更新对错标识
        for(int i=0;i<questions.size();i++){
            Question question = questions.get(i);
            Object correctAnswer = question.getCorrectAnswer();
            Object studentAnswer = studentAnswers.get(i);
            boolean isCorrect = correctAnswer.equals(studentAnswer);
            if(isCorrect){
                correctNumber++;
                obtainScore += question.getScore();
            }
            StudentAnswer studentAnswerObj = new StudentAnswer(isCorrect?1:2,studentAnswer);
            studentAnswerList.add(studentAnswerObj);
        }
        StudentPaper studentPaper = new StudentPaper()
                .setObtainScore(obtainScore)
                .setCorrectNumber(correctNumber)
                .setSubmitTime(LocalDateTime.now())
                .setFinishStatus(2)
                .setAnswers(JSON.toJSONString(studentAnswerList));
        studentPaperMapper.update(studentPaper,new UpdateWrapper<StudentPaper>().eq("student_id",paperResultDTO.getStudentId()).eq("paper_id",paperId));
    }

    public List<StudentPaperVO> getUnDonePapers(String studentId){
        return studentPaperMapper.selectStudentPaperList(studentId,2,false);
    }

    public List<MetaPaper> getMetaPapers(String teacherId){
        return metaPaperMapper.selectList(new QueryWrapper<MetaPaper>().eq("teacher_id",teacherId));
    }


    public List<StudentPaperVO> getDonePapers(String studentId){
        return studentPaperMapper.selectStudentPaperList(studentId,2,true);
    }

    public StudentPaperVO getPaperDetail(String paperId){
        return studentPaperMapper.selectStudentPaper(paperId);
    }
}
