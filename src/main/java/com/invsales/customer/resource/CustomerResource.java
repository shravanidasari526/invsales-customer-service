package com.invsales.customer.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invsales.customer.domain.Customer;
import com.invsales.customer.service.CustomerService;
import com.invsales.customer.serviceimpl.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerResource {
	private static final Logger logger = LoggerFactory.getLogger(CustomerResource.class);
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public void createCustomer(@RequestBody Customer customer) {
		logger.info("<< createCustomer() from CustomerResource");
		logger.debug("customer input object--->"+customer.toString());
		customerService.createCustomer(customer);	
		logger.info(">> createCustomer() from CustomerResource");
	}
	
	@GetMapping("/findById/{customerId}")
	public Customer getCustomerById(@PathVariable String customerId) {
		logger.info("<< getCustomerById() from CustomerResource");
		logger.debug("customer Id input --->"+customerId);
		Customer customer = customerService.findByCustomerId(customerId);
		logger.info(">> getCustomerById() from CustomerResource");
		return customer;
	}

}
