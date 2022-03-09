package com.myexam.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRoomDetailVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private StudentRoomVO room;
    private List<StudentPaperVO> papers;
}
