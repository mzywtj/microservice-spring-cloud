package com.itmouch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * http请求客户端
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerMovieFeignCuntomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieFeignCuntomApplication.class, args);
	}
}
