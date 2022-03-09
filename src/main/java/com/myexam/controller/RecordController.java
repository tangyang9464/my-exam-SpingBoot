package com.myexam.controller;

import com.myexam.entity.ResponseEntity;
import com.myexam.service.PaperService;
import com.myexam.vo.StudentPaperVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("examRecord")
public class RecordController {
    @Resource
    PaperService paperService;

    @RequestMapping("/list")
    public ResponseEntity<List<StudentPaperVO>> getDonePapers(String studentId){
        return ResponseEntity.success(paperService.getDonePapers(studentId));
    }
}
