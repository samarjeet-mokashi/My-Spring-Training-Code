package com.boa.restcontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.boa.discovery.Discovery;


@RestController
public class AdminControllerClient {

	@Autowired
	Discovery discoveryClass;

	@RequestMapping(value = "/getAllAdmins", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> getMessage() throws RestClientException, IOException {
		return discoveryClass.discoveryResult("BOA-Admin-MicroservicePRODUCER", "/api1/getAllAdmins", HttpMethod.GET);
	}

	@RequestMapping(value = "/addAdmin", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addAdmin(@RequestBody Map<String, Object> adminMap)
			throws RestClientException, IOException {
		return discoveryClass.discoveryResult("BOA-Admin-MicroservicePRODUCER", "/api1/addAdmin", HttpMethod.POST, adminMap);
	}


	@RequestMapping(value = "/updateAdmin/{id}", produces = "plain/text", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAdmin(@PathVariable Long id, @RequestBody Map<String, Object> adminMap)
			throws RestClientException, IOException {
		Map<String, Object> updateAdminMap = new HashMap<String, Object>();
		//updateAdminMap.put("Id", String.valueOf(id));
		updateAdminMap.put("id", id);
		updateAdminMap.put("Admin", adminMap);
		return discoveryClass.discoveryResult("BOA-Admin-MicroservicePRODUCER", "/api1/updateAdmin", HttpMethod.PUT, updateAdminMap);
	}
	
	@RequestMapping(value = "/deleteAdmin/{id}", produces = "plain/text", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAdmin(@PathVariable Long id)
			throws RestClientException, IOException {
		Map<String, Object> deleteAdminMap = new HashMap<String, Object>();
		deleteAdminMap.put("id", id);
		return discoveryClass.discoveryResult("BOA-Admin-MicroservicePRODUCER", "/api1/deleteAdmin", HttpMethod.DELETE, deleteAdminMap);
	}

}
