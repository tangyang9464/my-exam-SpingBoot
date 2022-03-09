package com.myexam.po;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ty
 * @since 2022-02-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String roomId;

    private String studentId;

    private String paperName;

    private BigDecimal totalScore;

    private BigDecimal obtainScore;

    private Integer questionNumber;

    private Long totalTime;

    private Timestamp deadline;
    private Timestamp submitTime;
    private Integer correctNumber;

    /**
     * 0-1-2 未开始-已经开始-已提交
     */
    private Integer finishStatus;
}
