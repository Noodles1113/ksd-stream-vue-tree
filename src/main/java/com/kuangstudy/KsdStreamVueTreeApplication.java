package com.kuangstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kuangstudy.mapper")
public class KsdStreamVueTreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(KsdStreamVueTreeApplication.class, args);
    }

}
