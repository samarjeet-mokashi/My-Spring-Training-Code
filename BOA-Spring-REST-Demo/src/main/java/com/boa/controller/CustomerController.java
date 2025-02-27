package com.boa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boa.model.Customer;
import com.boa.service.CustomerService;

@RestController
@RequestMapping("/customerApi")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/getAllCustomerDetails", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Customer> getAllCustomerDetails() {

		return CustomerService.getCustomers();
	}

	@GetMapping("/getCustomerDetails/{id}")
	public String getCustomerDetails(@PathVariable int id) throws NotFoundException {

		return customerService.getCustomerDetails(id);
	}

	@PutMapping("/updateCustomerDetails/{id}")
	public void updateCustomerDetails(@PathVariable int id) throws NotFoundException {
		customerService.updateCustomerDetails(id);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable int id) throws NotFoundException {
		customerService.deleteCustomer(id);
	}

	@PostMapping("/addCustomer")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

}
