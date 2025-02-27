package com.boa.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.boa.config.AppConfig;
import com.boa.service.CustomerService;
import com.boa.service.HelloWorld;

@SpringBootApplication
public class BoaSpringCoreDemoApplication {

	public static void main(String[] args) {
		/*
		 * SpringApplication.run(BoaSpringCoreDemoApplication.class, args);
		 * System.out.println("My first spring boot application");
		 */
		
		ApplicationContext context = SpringApplication.run(AppConfig.class);
		
		HelloWorld lookup = (HelloWorld) context.getBean("helloBean");
		
		System.out.println(lookup.printDetails("BOA Microservices Session"));
		
		CustomerService custLookup = (CustomerService) context.getBean("custBean");
		
		System.out.println(custLookup.getAllCustomer().toString());
	}

}
