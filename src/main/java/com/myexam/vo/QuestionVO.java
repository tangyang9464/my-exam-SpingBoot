package com.myexam.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;

    private String stem;

    /**
     *0,1,2--单选，多选，判断
     */
    private Integer questionType;

    /**
     * json数组字符串
     */
    private List<String> options;

    /**
     * 分值
     */
    private Double score;

    /**
     * 正确答案
     */
    private List<Object> correctAnswer;
}

