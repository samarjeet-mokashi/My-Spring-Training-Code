package com.boa.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.boa.*")
public class BoaSpringRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaSpringRestDemoApplication.class, args);
	}

}
