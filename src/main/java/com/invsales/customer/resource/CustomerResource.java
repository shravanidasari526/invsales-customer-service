package com.invsales.customer.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.invsales.customer.domain.Customer;
import com.invsales.customer.domain.Orders;
import com.invsales.customer.service.CustomerService;
import com.invsales.customer.serviceimpl.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerResource {
	private static final Logger logger = LoggerFactory.getLogger(CustomerResource.class);
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${service.orders.uri}")
	private String ordersServiceUri;
	
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

	@GetMapping("/findOrders/{customerId}")
	public List<Orders> findOrdersByCustomerId(@PathVariable String customerId) {
		//String requestUri = "http://localhost:8083/orders/findByCustomerId/{customerId}";
		Map<String, String> urlParameters = new HashMap<>();
		urlParameters.put("customerId", customerId);
		ResponseEntity<Orders[]> entity = restTemplate.getForEntity(ordersServiceUri, Orders[].class, urlParameters);
		return entity.getBody() != null ? Arrays.asList(entity.getBody()) : Collections.emptyList();

	}
}
