package com.myexam.vo;

import com.myexam.po.TeacherPaper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TeacherRoomDetailVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private TeacherRoomVO room;
    private List<TeacherPaper> papers;
}
