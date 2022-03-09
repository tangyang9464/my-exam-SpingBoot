package com.myexam.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnswerVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;

    private Object studentAnswer;
    /**
     * 0-待定，1-正确，2-错误
     */
    private Integer correctStatus;
}
