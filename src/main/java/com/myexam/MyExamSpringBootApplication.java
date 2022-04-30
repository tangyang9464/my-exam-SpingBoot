package com.myexam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.myexam.mapper")
@EnableScheduling
public class MyExamSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyExamSpringBootApplication.class, args);
    }

}
