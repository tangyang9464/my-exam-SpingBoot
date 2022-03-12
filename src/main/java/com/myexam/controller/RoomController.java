package com.myexam.controller;

import com.myexam.entity.ResponseEntity;
import com.myexam.service.RoomService;
import com.myexam.vo.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/classroom")
public class RoomController {
    @Resource
    RoomService roomService;

    @RequestMapping("/join")
    public ResponseEntity joinRoom(String roomId, String studentId){
        if(!roomService.isExist(roomId)){
            return ResponseEntity.fail("课堂号不存在!");
        }
        if(roomService.isJoin(roomId,studentId)){
            return ResponseEntity.fail("已在课堂中!");
        }
        roomService.joinRoom(roomId,studentId);
        return ResponseEntity.success();
    }

    @RequestMapping("/create")
    public ResponseEntity<String> createRoom(@RequestParam(required = false) String roomId,String course, String schoolClass, String teacherId){
        return ResponseEntity.success(roomService.createRoom(roomId,course,schoolClass,teacherId));
    }

    @RequestMapping("/historyList")
    public ResponseEntity<List<HistoryRoomVO>> getHistoryRooms(String studentId){
        return ResponseEntity.success(roomService.getHistoryRooms(studentId));
    }

    @RequestMapping("/list")
    public ResponseEntity<List<StudentRoomVO>> getRooms(String studentId){
        return ResponseEntity.success(roomService.getRooms(studentId));
    }

    @RequestMapping("/listTeacherRoom")
    public ResponseEntity<List<TeacherRoomVO>> listTeacherRoom(String teacherId){
        return ResponseEntity.success(roomService.listTeacherRoom(teacherId));
    }

    @RequestMapping("/joinHistoryRoom")
    public ResponseEntity joinHistoryRoom(String roomId,String studentId){
        roomService.joinHistoryRoom(roomId,studentId);
        return ResponseEntity.success();
    }

    @RequestMapping("/exitHistoryRoom")
    public ResponseEntity exitHistoryRoom(String roomId,String studentId){
        roomService.exitHistoryRoom(roomId,studentId);
        return ResponseEntity.success();
    }

    @RequestMapping("/exit")
    public ResponseEntity exitRoom(String roomId, String studentId){
        roomService.exitRoom(roomId,studentId);
        return ResponseEntity.success();
    }

    @RequestMapping("/detail")
    public ResponseEntity<StudentRoomDetailVO> getRoomDetail(String roomId,String studentId){
        StudentRoomDetailVO roomDetailVO = roomService.getStudentRoomDetail(roomId,studentId);
        return ResponseEntity.success(roomDetailVO);
    }
    @RequestMapping("/teacherDetail")
    public ResponseEntity<TeacherRoomDetailVO> getTeacherRoomDetail(String roomId){
        TeacherRoomDetailVO roomDetailVO = roomService.getTeacherRoomDetail(roomId);
        return ResponseEntity.success(roomDetailVO);
    }
}
