package com.wuou.users8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Users8002Application {

    public static void main(String[] args) {
        SpringApplication.run(Users8002Application.class, args);
    }

}
