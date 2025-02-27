package com.boa.restcontroller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.boa.discovery.Discovery;

@RestController
public class HelloControllerConsumer {
	
	@Autowired
	Discovery discoveryClass;

	@RequestMapping(value = "/getMessage", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> getMessage() throws RestClientException, IOException {
		return discoveryClass.discoveryResult("BOA-HelloWorld-MicroservicePRODUCER", "/api/lookup", HttpMethod.GET);
	}

		
		

}

