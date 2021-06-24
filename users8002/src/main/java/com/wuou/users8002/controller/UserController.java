package com.wuou.users8002.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Description
 * @Author wuou
 * @Date 2021/6/9 下午2:21
 * @Version 1.0.0
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/showProductMsg")
    public String showProductMsg(){
        String forObject = restTemplate.getForObject("http://products/product/showMsg", String.class);
        log.info("返回商品信息[{}]",forObject);
        /*List<ServiceInstance> products = discoveryClient.getInstances("products");
        for(ServiceInstance serviceInstance : products){
            log.info("返回商品服务地址[{}]",serviceInstance.getPort());
        }

        ServiceInstance products1 = loadBalancerClient.choose("products");
        log.info("返回loadBalancerClient商品服务地址[{}]",products1.getPort());*/

        return forObject;
    }

    @GetMapping("/user/showAllProduct")
    public Object showAllProduct(){
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://10.1.20.18:8003/product/findAll", String.class);
        log.info("商品服务调用结果[{}]",forObject);
        return forObject;
    }
}
