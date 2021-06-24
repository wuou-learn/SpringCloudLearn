package com.wuou.products8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class Products8003Application {

    public static void main(String[] args) {
        SpringApplication.run(Products8003Application.class, args);
    }

}
