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
 * @since 2022-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 学号
     */
    private String number;

    /**
     * 用户名，用于登录
     */
    private String username;

    private String salt;
    private String password;

    /**
     * 展示名
     */
    private String displayName;

    /**
     * 学校名称
     */
    private String school;

    private String email;

    /**
     * 0-学生，1-老师
     */
    private Integer role;

    private String avatar;


}
