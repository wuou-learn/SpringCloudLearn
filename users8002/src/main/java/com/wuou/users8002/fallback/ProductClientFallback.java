package com.wuou.users8002.fallback;

import com.wuou.users8002.clients.ProductsClient;
import com.wuou.users8002.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author wuou
 * @Date 2021/6/10 下午5:19
 * @Version 1.0.0
 */
@Component
public class ProductClientFallback implements ProductsClient {
    @Override
    public String showMsg() {
        return null;
    }

    @Override
    public Map<String, Object> findAll() {
        return null;
    }

    @Override
    public Map<String, Object> findOne(String productId) {
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("msg","user-->hystrix降级");
        return stringObjectHashMap;
    }

    @Override
    public Map<String, Object> save(Product product) {
        return null;
    }
}
