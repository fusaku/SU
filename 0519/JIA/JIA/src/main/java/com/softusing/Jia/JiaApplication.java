package com.softusing.Jia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.softusing.Jia.mapper")
public class JiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiaApplication.class, args);
    }

}
