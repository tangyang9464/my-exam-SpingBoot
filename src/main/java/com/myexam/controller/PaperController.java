package com.myexam.controller;

import com.myexam.DTO.PaperResultDTO;
import com.myexam.DTO.PublishInfoDTO;
import com.myexam.entity.ResponseEntity;
import com.myexam.po.MetaPaper;
import com.myexam.po.TeacherPaper;
import com.myexam.service.PaperService;
import com.myexam.vo.StudentPaperVO;
import com.myexam.vo.TeacherPaperVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {
    @Resource
    PaperService paperService;

    @RequestMapping("/detail")
    public ResponseEntity<StudentPaperVO> getStudentPaperDetail(String paperId){
        return ResponseEntity.success(paperService.getPaperDetail(paperId));
    }

    @RequestMapping("/startAnswering")
    public ResponseEntity startAnswering(String studentId, String paperId){
        paperService.startAnswering(studentId,paperId);
        return ResponseEntity.success();
    }

    @RequestMapping("/submit")
    public ResponseEntity submit(@RequestBody PaperResultDTO paperResultDTO){
        paperService.submit(paperResultDTO);
        return ResponseEntity.success();
    }

    @RequestMapping("/tempSave")
    public ResponseEntity tempSave(@RequestBody PaperResultDTO paperResultDTO){
        paperService.tempSave(paperResultDTO);
        return ResponseEntity.success();
    }

    @RequestMapping("/undonePapers")
    public ResponseEntity<List<StudentPaperVO>> getUndonePapers(String studentId){
        return ResponseEntity.success(paperService.getUnDonePapers(studentId));
    }

    @RequestMapping("/metaPapers")
    public ResponseEntity<List<MetaPaper>> getMetaPapers(String teacherId){
        return ResponseEntity.success(paperService.getMetaPapers(teacherId));
    }

    @RequestMapping("/getTeacherPaper")
    public ResponseEntity<TeacherPaperVO> getTeacherPaper(String teacherPaperId){
        return ResponseEntity.success(paperService.getTeacherPaper(teacherPaperId));
    }

    @RequestMapping("/getStudentPaper")
    public ResponseEntity<StudentPaperVO> getStudentPaper(String studentPaperId){
        return ResponseEntity.success(paperService.getStudentPaper(studentPaperId));
    }

    @RequestMapping("/createMetaPaper")
    public ResponseEntity createMetaPaper(@RequestBody MetaPaper metaPaper){
        paperService.createMetaPaper(metaPaper);
        return ResponseEntity.success();
    }

    @RequestMapping("/getMetaPaper")
    public ResponseEntity<MetaPaper> getMetaPaperDetail(String paperId){
        return ResponseEntity.success(paperService.getMetaPaper(paperId));
    }

    @RequestMapping("/deleteMetaPaper")
    public ResponseEntity deleteMetaPaper(String paperId){
        paperService.deleteMetaPaper(paperId);
        return ResponseEntity.success();
    }

    @RequestMapping("/updateMetaPaper")
    public ResponseEntity<MetaPaper> updateMetaPaper(@RequestBody MetaPaper metaPaper){
        paperService.updateMetaPaper(metaPaper);
        return ResponseEntity.success();
    }

    @RequestMapping("/publishPaper")
    public ResponseEntity publishPaper(@RequestBody PublishInfoDTO publishInfo){
        paperService.publishPaper(publishInfo);
        return ResponseEntity.success();
    }
}
