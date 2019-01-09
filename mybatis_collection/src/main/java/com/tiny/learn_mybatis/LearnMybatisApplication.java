package com.tiny.learn_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tiny.learn_mybatis.dao")
public class LearnMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnMybatisApplication.class, args);
    }
}
