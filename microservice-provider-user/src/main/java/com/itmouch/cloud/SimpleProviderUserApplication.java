package com.itmouch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
public class SimpleProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleProviderUserApplication.class, args);
	}
}
