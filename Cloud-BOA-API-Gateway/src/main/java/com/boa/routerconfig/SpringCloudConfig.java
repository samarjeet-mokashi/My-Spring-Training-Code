package com.boa.routerconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class SpringCloudConfig {

	@Bean
	public RouterFunction<ServerResponse> adminServiceRoute(){
		
	     return GatewayRouterFunctions.route("BOA-Admin-MicroservicePRODUCER")
	    		 .route(RequestPredicates.path("/api1/*"), HandlerFunctions.http("http://localhost:8083"))
	    		 .build();
	
	}
	
	@Bean
	public RouterFunction<ServerResponse> registrationServiceRoute(){
		
	     return GatewayRouterFunctions.route("BOA-Registration-MicroservicePRODUCER")
	    		 .route(RequestPredicates.path("/api2/*"), HandlerFunctions.http("http://localhost:8084"))
	    		 .build();
	
	}
}
