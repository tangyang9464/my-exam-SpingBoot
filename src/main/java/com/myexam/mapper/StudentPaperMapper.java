package com.myexam.mapper;

import com.myexam.po.StudentPaper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myexam.vo.StudentPaperVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ty
 * @since 2022-03-05
 */
public interface StudentPaperMapper extends BaseMapper<StudentPaper> {
    StudentPaperVO selectStudentPaper(String paperId);
    List<StudentPaperVO> selectStudentPaperList(String studentId, Integer finishStatus,boolean condition);
}
