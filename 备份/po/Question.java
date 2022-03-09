package com.myexam.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ty
 * @since 2022-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String stem;

    /**
     * singleChoice, multipleChoice, judge --单选，多选，判断
     */
    private String questionType;

    /**
     * json数组字符串
     */
    private String options;

    /**
     * 分值
     */
    private Double score;

    /**
     * 正确答案
     */
    private String correctAnswer;
}
