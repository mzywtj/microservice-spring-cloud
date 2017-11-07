package com.itmouch.cloud;

import com.itmouch.cloud.entity.User;
import com.itmouch.config.FooConfiguration;
import com.itmouch.config.FooConfiguration2;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="xxxx",url = "http://localhost:8761/",configuration = FooConfiguration2.class)
public interface FeignClient2 {

    @RequestMapping(value = "/eureka/apps/{serviceName}")
   public String test(@PathVariable("serviceName") String serviceName);
}
