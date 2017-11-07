package com.itmouch.cloud.controller;

import com.itmouch.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        User user = restTemplate.getForObject("http://microservice-provider-user/simple/"+id, User.class);
        return user;
    }

    @GetMapping("/userList")
    public List<User> userList(){
        User[] users = restTemplate.getForObject("http://microservice-provider-user/userList", User[].class);
        List<User> userList = Arrays.asList(users);
        return userList;
    }
    @GetMapping("/test")
    public String test(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        System.out.println("1111"+serviceInstance.getHost()+":"+serviceInstance.getPort()
                +":"+serviceInstance.getServiceId());

        System.out.println("===========");
        ServiceInstance serviceInstance2 = loadBalancerClient.choose("microservice-provider-user2");
        System.out.println("2222"+serviceInstance2.getHost()+":"+serviceInstance2.getPort()
                +":"+serviceInstance2.getServiceId());
        return "1";
    }
}
