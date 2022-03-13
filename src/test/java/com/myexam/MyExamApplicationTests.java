package com.myexam;

import com.myexam.mapper.RoomMapper;
import com.myexam.vo.StudentRoomDetailVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MyExamApplicationTests {

    @Resource
    RoomMapper roomMapper;


    @Test
    void contextLoads() {
        StudentRoomDetailVO combon = roomMapper.selectStudentRoomDetail("1501801308460421121","1502526352744640513");
         System.out.println();
    }

}
