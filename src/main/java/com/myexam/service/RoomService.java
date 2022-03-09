package com.myexam.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.myexam.mapper.RoomMapper;
import com.myexam.mapper.RoomStudentMergeMapper;
import com.myexam.mapper.StudentPaperMapper;
import com.myexam.po.Room;
import com.myexam.po.RoomStudentMerge;
import com.myexam.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    @Resource
    RoomStudentMergeMapper roomStudentMergeMapper;
    @Resource
    RoomMapper roomMapper;

    public boolean isExist(String roomId){
        return roomMapper.selectById(roomId) != null;
    }

    public RoomStudentMerge getRoomStudentMergeById(String roomId, String studentId){
        return roomStudentMergeMapper.selectOne(new QueryWrapper<RoomStudentMerge>().eq("room_id",roomId).eq("student_id",studentId));
    }

    public boolean isJoin(String roomId, String studentId){
        return roomStudentMergeMapper.selectOne(new QueryWrapper<RoomStudentMerge>().eq("room_id",roomId).eq("student_id",studentId)) != null;
    }
    public String createRoom(String roomId,String course, String schoolClass, String teacherId){
        Room room = new Room()
                .setCourse(course)
                .setSchoolClass(schoolClass)
                .setTeacherId(teacherId);
        if(roomId!=null){
            room.setId(roomId);
            roomMapper.updateById(room);
            return "";
        }
        roomMapper.insert(room);
        return room.getId();
    }

    public int joinRoom(String roomId, String studentId){
        RoomStudentMerge RoomStudentMerge = new RoomStudentMerge();
        RoomStudentMerge.setRoomId(roomId);
        RoomStudentMerge.setStudentId(studentId);
        return roomStudentMergeMapper.insert(RoomStudentMerge);
    }

    public int exitRoom(String roomId, String studentId){
        return roomStudentMergeMapper.delete(new UpdateWrapper<RoomStudentMerge>().eq("room_id",roomId).eq("student_id",studentId));
    }

    public StudentRoomDetailVO getStudentRoomDetail(String roomId,String studentId){
       return roomMapper.selectStudentRoomDetail(roomId,studentId);
    }

    public TeacherRoomDetailVO getTeacherRoomDetail(String roomId, String teacherId){
        return roomMapper.selectTeacherRoomDetail(roomId,teacherId).setRoom(getTeacherRoom(roomId));
    }

    public List<HistoryRoomVO> getHistoryRooms(String studentId){
        List<HistoryRoomVO> res = roomMapper.selectStudentHistoryRoomList(studentId);
        for(HistoryRoomVO historyRoomVO:res){
            historyRoomVO.setStudentNumber(roomStudentMergeMapper.selectCount(new QueryWrapper<RoomStudentMerge>().eq("room_id",historyRoomVO.getId())));
        }
       return res;
    }

    public List<StudentRoomVO> getRooms(String studentId){
        return roomMapper.selectStudentRoomList(studentId,0);
    }

    public List<TeacherRoomVO> listTeacherRoom(String teacherId){
        List<TeacherRoomVO> res = new ArrayList<>();
        List<Room> rooms = roomMapper.selectList(new QueryWrapper<Room>().eq("teacher_id",teacherId));
        for(Room room:rooms){
            TeacherRoomVO teacherRoomVO = new TeacherRoomVO();
            BeanUtils.copyProperties(room,teacherRoomVO);
            int count = roomStudentMergeMapper.selectCount(new QueryWrapper<RoomStudentMerge>().eq("room_id",room.getId()));
            teacherRoomVO.setStudentNumber(count);
            res.add(teacherRoomVO);
        }
        return res;
    }

    public TeacherRoomVO getTeacherRoom(String roomId){
        Room room = roomMapper.selectById(roomId);
        TeacherRoomVO teacherRoomVO = new TeacherRoomVO();
        BeanUtils.copyProperties(room,teacherRoomVO);
        int count = roomStudentMergeMapper.selectCount(new QueryWrapper<RoomStudentMerge>().eq("room_id",roomId));
        teacherRoomVO.setStudentNumber(count);
        return teacherRoomVO;
    }

    public int joinHistoryRoom(String roomId,String studentId){
        RoomStudentMerge RoomStudentMerge = getRoomStudentMergeById(roomId,studentId);
        if(RoomStudentMerge==null){
            return 0;
        }
        RoomStudentMerge.setArchiveStatus(1);
        return roomStudentMergeMapper.updateById(RoomStudentMerge);
    }

    public int exitHistoryRoom(String roomId,String studentId){
        RoomStudentMerge RoomStudentMerge = getRoomStudentMergeById(roomId,studentId);
        if(RoomStudentMerge==null){
            return 0;
        }
        RoomStudentMerge.setArchiveStatus(0);
        return roomStudentMergeMapper.updateById(RoomStudentMerge);
    }
}
