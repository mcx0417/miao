package com.mcx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
@MapperScan("com.mcx.mapper")
public class LoveApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoveApplication.class,args);
    }
}
