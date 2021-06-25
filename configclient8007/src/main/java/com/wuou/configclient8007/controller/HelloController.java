package com.wuou.configclient8007.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author wuou
 * @Date 2021/6/25 下午3:13
 * @Version 1.0.0
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/client/testPort")
    public String TestPort(){
        return "port-->"+port;
    }

}
