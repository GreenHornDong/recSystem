package com.recSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.recSystem.Mapper")
public class RecSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecSystemApplication.class, args);
    }
}
