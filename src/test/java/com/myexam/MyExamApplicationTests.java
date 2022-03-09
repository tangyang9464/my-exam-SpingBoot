package com.myexam;

import com.myexam.mapper.RoomMapper;
import com.myexam.mapper.StudentPaperMapper;
import com.myexam.vo.StudentPaperVO;
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
            System.out.println();
    }

}
