package com.boa.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.boa.*")
@EnableDiscoveryClient
public class BoaHelloWorldMicroserviceProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaHelloWorldMicroserviceProducerApplication.class, args);
	}

}
