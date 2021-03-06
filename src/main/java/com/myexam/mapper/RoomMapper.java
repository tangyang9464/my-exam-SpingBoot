package com.myexam.mapper;

import com.myexam.po.Room;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myexam.vo.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ty
 * @since 2022-03-05
 */
public interface RoomMapper extends BaseMapper<Room> {
    StudentRoomDetailVO selectStudentRoomDetail (String roomId,String studentId);
    List<StudentRoomVO> selectStudentRoomList (String studentId,Integer archiveStatus);
    List<HistoryRoomVO> selectStudentHistoryRoomList (String studentId);
    StudentRoomVO selectStudentRoom (String roomId);
    TeacherRoomVO selectTeacherRoom (String roomId);
}
