package com.myexam.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PublishInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String roomId;
    private String publishName;
    private Integer total_time;
    private LocalDateTime startTime;
    private LocalDateTime deadline;
}
