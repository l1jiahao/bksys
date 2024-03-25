package com.t6.bksys;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.t6.bksys.mapper")
@EnableScheduling
public class BksysApplication {

    public static void main(String[] args) {
        SpringApplication.run(BksysApplication.class, args);
    }

}
