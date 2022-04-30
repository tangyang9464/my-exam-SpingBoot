package com.myexam.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import com.myexam.json.StudentAnswer;
import com.myexam.json.handler.StudentAnswerTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ty
 * @since 2022-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(autoResultMap = true)
public class StudentPaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    private String studentId;

    private String teacherPaperId;
    private String teacherId;
    private String metaPaperId;
    private String roomId;

    private Double obtainScore;

    /**
     * 题目正确数量
     */
    private Integer correctNumber;

    private LocalDateTime submitTime;

    /**
     * 0-1-2 未开始-已提交/未批改-已批改
     */
    private Integer finishStatus;

    @TableField(typeHandler = StudentAnswerTypeHandler.class)
    private List<StudentAnswer> studentAnswers;

    private LocalDateTime actualStartTime;

    private Long totalTime;

    private LocalDateTime deadline;
    private String publishName;
    private LocalDateTime allowedStartTime;
}
