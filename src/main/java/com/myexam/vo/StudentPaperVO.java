package com.myexam.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.myexam.json.Question;
import com.myexam.json.StudentAnswer;
import com.myexam.json.handler.QuestionListTypeHandler;
import com.myexam.json.handler.StudentAnswerTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(autoResultMap = true)
public class StudentPaperVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String teacherPaperId;
    private String metaPaperId;
    private String publishName;
    private Long totalTime;
    private Double totalScore;
    private Integer questionNumber;
    /**
     * 题目正确数量
     */
    private Integer correctNumber;
    private LocalDateTime allowedStartTime;
    private LocalDateTime actualStartTime;
    private LocalDateTime deadline;
    private Double obtainScore;
    private LocalDateTime submitTime;
    /**
     * 0-1-2 未开始-已经开始-已提交
     */
    private Integer finishStatus;

    @TableField(typeHandler = QuestionListTypeHandler.class)
    private List<Question> questions;
    @TableField(typeHandler = StudentAnswerTypeHandler.class)
    private List<StudentAnswer> studentAnswers;
}
