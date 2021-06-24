package com.wuou.users8002.controller;

import com.wuou.users8002.clients.ProductsClient;
import com.wuou.users8002.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description
 * @Author wuou
 * @Date 2021/6/9 下午5:17
 * @Version 1.0.0
 */
@RestController
@Slf4j
public class FeignController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ProductsClient productsClient;

    @GetMapping("/feign/test")
    public String test(){
        String msg = productsClient.showMsg();
        log.info("feign-->{}",msg);
        return msg;
    }

    @GetMapping("/feign/findOne")
    public Object findOne(String id){
        Map<String, Object> one = productsClient.findOne(id);
        log.info("feign-->{}",one);
        log.info("port-->{}",port);
        return one;
    }

    @PostMapping("/feign/save")
    public Object save(Product product){
        Map<String, Object> one = productsClient.save(product);
        log.info("feign-->{}",one);
        return one;
    }
}
