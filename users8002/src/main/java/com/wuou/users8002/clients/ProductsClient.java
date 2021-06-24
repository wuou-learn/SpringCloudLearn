package com.wuou.users8002.clients;

import com.wuou.users8002.fallback.ProductClientFallback;
import com.wuou.users8002.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Description
 * @Author wuou
 * @Date 2021/6/9 下午5:31
 * @Version 1.0.0
 */
@FeignClient(value = "products",fallback = ProductClientFallback.class)
public interface ProductsClient {

    @GetMapping("/product/showMsg")
    String showMsg();

    @GetMapping("/product/findAll")
    Map<String,Object> findAll();

    @GetMapping("/product/findOne")
    Map<String,Object> findOne(@RequestParam("productId") String productId);

    @PostMapping("/product/save")
    Map<String,Object> save(@RequestBody Product product);
}
