package com.invsales.customer.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invsales.customer.InvsalesCustomerServiceApplication;
import com.invsales.customer.domain.Customer;
import com.invsales.customer.repository.CustomerRepository;
import com.invsales.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void createCustomer(Customer customer) {
		logger.info("<< createCustomer() from CustomerServiceImpl");
		customerRepository.save(customer);
		logger.info(">> createCustomer() from CustomerServiceImpl");

	}

	@Override
	public Customer findByCustomerId(String customerId) {
		logger.info("<< findByCustomerId() from CustomerServiceImpl");
		Optional<Customer> customer = customerRepository.findById(customerId);
		logger.info(">> findByCustomerId() from CustomerServiceImpl");
		return customer.get();
	}

}
