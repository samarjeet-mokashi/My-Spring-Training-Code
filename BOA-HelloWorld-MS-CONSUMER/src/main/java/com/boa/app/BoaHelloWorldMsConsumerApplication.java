package com.boa.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@ComponentScan("com.boa.*")
public class BoaHelloWorldMsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaHelloWorldMsConsumerApplication.class, args);
	}

}
