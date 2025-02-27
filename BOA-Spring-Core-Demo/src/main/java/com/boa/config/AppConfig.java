package com.boa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boa.service.CustomerService;
import com.boa.service.CustomerServiceImpl;
import com.boa.service.HelloWorld;
import com.boa.service.HelloWorldImpl;

@Configuration
public class AppConfig {
	
	@Bean(name="helloBean")
	public HelloWorld helloWorld() {
		return new HelloWorldImpl();
	}
	
	@Bean(name="custBean")
	public CustomerService customerService() {
		return new CustomerServiceImpl();
	}

}
