package com.wuou.products8003.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wuou.products8003.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author wuou
 * @Date 2021/6/9 下午2:13
 * @Version 1.0.0
 */
@RestController
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private int value;

    @GetMapping("/product/showMsg")
    public String showMsg(){
        log.info("展示商品信息--->");

        return "进入商品服务，展示商品信息--->,当前端口为"+value;
    }

    @GetMapping("/product/findAll")
    public Map<String,Object> findAll(){
        Map<String,Object> map = new HashMap<>();
        map.put("json","hello "+value);
        return map;
    }

    @GetMapping("/product/findOne")
//    @HystrixCommand(fallbackMethod = "fallback")
    public Map<String,Object> findOne(String productId){
        if(productId == null){
            throw new RuntimeException("传入ID为null。");
        }
        Map<String,Object> map = new HashMap<>();
        log.info("productId-->"+productId);
        map.put("productId",productId);
        map.put("data","商品信息--> zzz");
        map.put("port",value);
        return map;
    }

    public Map<String,Object> fallback(String productId){
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("msg","传入ID为null。");
        return stringObjectHashMap;
    }

    @PostMapping("/product/save")
    public Map<String,Object> save(@RequestBody Product product) throws InterruptedException {
        Map<String,Object> map = new HashMap<>();
        log.info("product-->"+product);
        map.put("data","保存成功--> zzz");
        map.put("商品对象-->",product);
        map.put("port",value);
        return map;
    }

}
