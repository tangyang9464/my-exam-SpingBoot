package com.myexam.mapper;

import com.myexam.po.TeacherPaper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myexam.vo.TeacherPaperVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ty
 * @since 2022-03-05
 */
public interface TeacherPaperMapper extends BaseMapper<TeacherPaper> {
    TeacherPaperVO selectTeacherPaper(String paperId);
    List<TeacherPaperVO> listTeacherPaperByRoomId (String roomId);
}
