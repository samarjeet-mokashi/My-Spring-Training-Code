package com.boa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BoaEurekaServerMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaEurekaServerMicroservicesApplication.class, args);
	}

}
