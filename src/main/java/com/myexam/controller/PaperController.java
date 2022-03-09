package com.myexam.controller;

import com.myexam.DTO.PaperResultDTO;
import com.myexam.entity.ResponseEntity;
import com.myexam.po.MetaPaper;
import com.myexam.service.PaperService;
import com.myexam.vo.StudentPaperVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/studentPaper")
public class PaperController {
    @Resource
    PaperService paperService;

    @RequestMapping("/detail")
    public ResponseEntity<StudentPaperVO> getStudentPaperDetail(String paperId){
        return ResponseEntity.success(paperService.getPaperDetail(paperId));
    }

    @RequestMapping("/submit")
    public ResponseEntity submit(@RequestBody PaperResultDTO paperResultDTO){
        paperService.submit(paperResultDTO);
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
}
