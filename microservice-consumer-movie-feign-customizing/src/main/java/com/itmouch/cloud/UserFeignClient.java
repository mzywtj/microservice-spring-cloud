package com.itmouch.cloud;

import com.itmouch.cloud.entity.User;
import com.itmouch.config.FooConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="microservice-provider-user",configuration = FooConfiguration.class)
public interface UserFeignClient {
    @RequestLine("GET /simple/{id}")
    User findById(@Param("id") Long id);
}
