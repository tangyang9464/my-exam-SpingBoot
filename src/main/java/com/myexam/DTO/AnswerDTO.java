package com.myexam.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AnswerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String questionId;
    private List<String> options;
}
