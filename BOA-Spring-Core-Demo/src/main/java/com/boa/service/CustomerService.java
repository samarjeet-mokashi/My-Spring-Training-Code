package com.boa.service;

import java.util.List;

import com.boa.model.CustomerModel;

public interface CustomerService {
	
	public void addCustomer(CustomerModel cust);
	
	public void deleteCustomer(int custId);
	
	public List<CustomerModel> getAllCustomer();
	
	public void getCustomer(int custId);

}
