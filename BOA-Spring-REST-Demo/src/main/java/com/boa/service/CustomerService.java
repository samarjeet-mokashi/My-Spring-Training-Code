package com.boa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.boa.model.Customer;

@Service
public class CustomerService {

	private static ArrayList<Customer> custList = new ArrayList<>();
	
	static {
		custList = new ArrayList<>();
		custList.add(new Customer(1, "Name1", "Address1"));
		custList.add(new Customer(2, "Name2", "Address2"));
	}

	public static List<Customer> getCustomers() {
		return custList;
	}

	public List<Customer> getAllCustomerDetails() {

		return getCustomers();
	}

	public String getCustomerDetails(int id) throws NotFoundException {
		Optional<Customer> Customer = custList.stream().filter(b -> b.getCustomerID() == id).findAny();
		if (!Customer.isPresent())
			throw new NotFoundException(); 

		return Customer.get().toString();
	}

	public void updateCustomerDetails(int id) throws NotFoundException {
		Optional<Customer> Customer = custList.stream().filter(b -> b.getCustomerID() == id).findAny();
		if (!Customer.isPresent())
			throw new NotFoundException();

		Customer.get().setCustomerAddress("NewAddress");
	}

	public void deleteCustomer(int id) throws NotFoundException {
		for (Customer b : custList) {
			if (b.getCustomerID() == id) {
				custList.remove(b);
				return;
			}
		}
		throw new NotFoundException();
	}

	public void addCustomer(Customer customer) {
		custList.add(customer);
	}

}
