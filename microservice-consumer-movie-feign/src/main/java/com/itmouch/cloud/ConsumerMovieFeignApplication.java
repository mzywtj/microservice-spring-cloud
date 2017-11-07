package com.itmouch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * http请求客户端
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerMovieFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieFeignApplication.class, args);
	}
}
