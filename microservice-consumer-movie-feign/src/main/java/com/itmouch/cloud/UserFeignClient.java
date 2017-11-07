package com.itmouch.cloud;

import com.itmouch.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/simple/{id}")
    User findById(@PathVariable("id") Long id);
}
