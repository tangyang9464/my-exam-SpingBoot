package com.myexam.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.myexam.json.Question;
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
    private String paperName;
    private long totalTime;
    private Double totalScore;
    private Integer questionNumber;
    private LocalDateTime deadline;
    private Double obtainScore;
    private LocalDateTime submitTime;
    /**
     * 0-1-2 未开始-已经开始-已提交
     */
    private Integer finishStatus;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Question> questions;
    private List<AnswerVO> studentAnswers;
}
