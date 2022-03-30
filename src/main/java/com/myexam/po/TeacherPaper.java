package com.myexam.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
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
public class TeacherPaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    private String teacherId;

    private String metaPaperId;

    private String roomId;

    /**
     * 未完成人数
     */
    private Integer undoneNumber;

    private Integer doneNumber;
    /**
     * 所有学生得分
     */
    private Double allScore;

    /**
     * 所有学生正确题目数汇总
     */
    private Integer correctQuestionNumber;

    /**
     * 学生每题的选项分布
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<List<Integer>> studentOptionDistribution;

    private Long totalTime;

    private LocalDateTime deadline;
    private String publishName;
}
