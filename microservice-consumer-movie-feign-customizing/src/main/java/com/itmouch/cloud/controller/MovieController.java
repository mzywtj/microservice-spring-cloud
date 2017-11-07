package com.itmouch.cloud.controller;

import com.itmouch.cloud.FeignClient2;
import com.itmouch.cloud.UserFeignClient;
import com.itmouch.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {


    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private FeignClient2 feignClient2;


    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    @GetMapping("/test/{serviceName}")
    public String test(@PathVariable("serviceName") String serviceName) {
        return feignClient2.test(serviceName);
    }
}
