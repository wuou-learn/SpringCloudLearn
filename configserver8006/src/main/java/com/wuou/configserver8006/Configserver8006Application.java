package com.wuou.configserver8006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Configserver8006Application {

    public static void main(String[] args) {
        SpringApplication.run(Configserver8006Application.class, args);
    }

}
