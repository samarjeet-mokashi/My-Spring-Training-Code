package com.boa.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.boa.*")
@EnableJpaRepositories("com.boa.repository")
@EntityScan("com.boa.entity")
@EnableDiscoveryClient
@CrossOrigin
public class BoaRegistrationMicroserviceProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaRegistrationMicroserviceProducerApplication.class, args);
	}

}
