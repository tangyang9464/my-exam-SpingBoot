package com.myexam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.myexam.mapper")
public class MyExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyExamApplication.class, args);
    }

}
