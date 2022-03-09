package com.myexam.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 课程名
     */
    private String course;

    /**
     * 班级名
     */
    private String schoolClass;

    /**
     * 授课教师
     */
    private String teacherId;
}
