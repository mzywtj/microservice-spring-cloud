package com.itmouch.cloud.controller;


import com.itmouch.cloud.entity.User;
import com.itmouch.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient discoveryClient;
    @Qualifier("discoveryClient")
    @Autowired
    private DiscoveryClient client;


    /**
     * 获取eureka实例
     * @return
     */
    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }


    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
     return repository.findOne(id);
    }
    @GetMapping("/eureka-info")
    public ServiceInstance showInfo(){
        ServiceInstance instance = client.getLocalServiceInstance();
        return instance;
    }
}
