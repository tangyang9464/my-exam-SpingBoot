package com.myexam.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.myexam.json.Question;
import com.myexam.json.handler.QuestionListTypeHandler;
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
public class TeacherPaperVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String publishName;
    private long totalTime;
    private Double totalScore;
    private Integer questionNumber;
    private LocalDateTime deadline;

    /**
     * 未完成人数
     */
    private Integer undoneNumber;
    private Integer doneNumber;

    /**
     * 所有学生得分
     */
    private Integer allScore;

    /**
     * 所有学生正确题目数汇总
     */
    private Integer correctQuestionNumber;

    /**
     * 学生每题的选项分布
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<List<Integer>> studentOptionDistribution;
    @TableField(typeHandler = QuestionListTypeHandler.class)
    private List<Question> questions;
}
