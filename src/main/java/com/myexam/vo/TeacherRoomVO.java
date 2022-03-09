package com.myexam.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherRoomVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 课程名
     */
    private String course;

    /**
     * 班级名
     */
    private String schoolClass;

    private Integer studentNumber;
}
