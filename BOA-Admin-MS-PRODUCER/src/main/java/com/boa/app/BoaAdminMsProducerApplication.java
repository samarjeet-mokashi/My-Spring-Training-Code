package com.boa.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.boa.*")
@EnableJpaRepositories("com.boa.dao")
@EntityScan("com.boa.entity")
//@EnableDiscoveryClient
public class BoaAdminMsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaAdminMsProducerApplication.class, args);
	}

}
