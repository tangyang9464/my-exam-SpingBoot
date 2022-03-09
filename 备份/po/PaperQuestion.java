package com.myexam.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author ty
 * @since 2022-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PaperQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String paperId;

    private String questionId;

    /**
     * 作答的答案，单个字母，或者json数组字符串
     */
    private String studentAnswer;

    /**
     * 0-待定，1-正确，2-错误
     */
    private Integer status;


}
