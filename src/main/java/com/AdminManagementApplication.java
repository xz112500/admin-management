package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.dao")
@EnableSwagger2
public class AdminManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminManagementApplication.class, args);
    }

}
