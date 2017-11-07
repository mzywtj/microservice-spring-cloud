package com.itmouch.cloud.controller;

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
    private RestTemplate restTemplate;

    @Value("${userServicePath}")
    private String userServicePath;
    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        User user = restTemplate.getForObject(userServicePath + id, User.class);
        return user;
    }
}
