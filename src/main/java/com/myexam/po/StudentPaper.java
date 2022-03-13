package com.myexam.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ty
 * @since 2022-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StudentPaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    private String studentId;

    private String teacherPaperId;
    private String metaPaperId;
    private String roomId;

    private Double obtainScore;

    /**
     * 题目正确数量
     */
    private Integer correctNumber;

    private LocalDateTime submitTime;

    /**
     * 0-1-2 未开始-已提交/未批改-已批改
     */
    private Integer finishStatus;

    private String answers;

    private LocalDateTime actualStartTime;

    private Long totalTime;
    private Double totalScore;

    private LocalDateTime deadline;
    private String publishName;
    private LocalDateTime allowedStartTime;
}
