package com.wuou.eurekaclent8888;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Eurekaclent8888Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaclent8888Application.class, args);
    }

}
