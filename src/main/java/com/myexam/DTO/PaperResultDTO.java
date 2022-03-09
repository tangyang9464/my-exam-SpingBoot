package com.myexam.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PaperResultDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String studentId;
    private String paperId;
    private List<Object> answers;
//    private List<AnswerDTO> multipleAnswers;
}
