package com.invsales.customer.service;

import com.invsales.customer.domain.Customer;

public interface CustomerService {

	public void createCustomer(Customer customer);
	
	public Customer findByCustomerId(String customerId);
	
}
