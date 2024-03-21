package com.t6.bksys;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.t6.bksys.mapper")
public class BksysApplication {

    public static void main(String[] args) {
        SpringApplication.run(BksysApplication.class, args);
    }

}
