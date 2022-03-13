package com.myexam.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

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
public class TeacherPaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    private String teacherId;

    private String metaPaperId;

    private String roomId;

    /**
     * 未完成人数
     */
    private Integer undoneNumber;

    private Integer doneNumber;

    private Long totalTime;
    private Double totalScore;

    private LocalDateTime deadline;
    private String publishName;
}
