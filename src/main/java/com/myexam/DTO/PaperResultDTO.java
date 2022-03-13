package com.myexam.DTO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class PaperResultDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String studentPaperId;
    private String teacherPaperId;
    private String metaPaperId;
    private List<Object> answers;
//    private List<AnswerDTO> multipleAnswers;
}
