package com.myexam.json;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;

    private String stem;

    /**
     *0,1,2--单选，多选，判断
     */
    private Integer questionType;

    /**
     * json数组字符串
     */
    private Object options;

    /**
     * 分值
     */
    private Double score;

    private Object correctAnswer;
}

