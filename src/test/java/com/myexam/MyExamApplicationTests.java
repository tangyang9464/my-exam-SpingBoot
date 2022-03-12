package com.myexam;

import com.myexam.mapper.MetaPaperMapper;
import com.myexam.mapper.TeacherPaperMapper;
import com.myexam.po.MetaPaper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MyExamApplicationTests {

    @Resource
    TeacherPaperMapper teacherPaperMapper;
    @Resource
    MetaPaperMapper metaPaperMapper;

    @Test
    void contextLoads() {
        MetaPaper metaPaper = metaPaperMapper.selectById("1501830751929270273");
        System.out.println();
    }

}
