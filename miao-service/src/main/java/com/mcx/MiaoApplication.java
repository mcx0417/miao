package com.mcx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.mcx.mapper")
@EnableEurekaClient
public class MiaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiaoApplication.class,args);
    }
}
