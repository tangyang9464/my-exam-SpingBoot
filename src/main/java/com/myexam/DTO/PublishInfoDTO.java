package com.myexam.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PublishInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String teacherId;
    private String metaPaperId;
    private List<String> roomIds;
    private String publishName;
    private Long totalTime;
    private LocalDateTime allowedStartTime;
    private LocalDateTime deadline;
    private Integer undoneNumber;
}
