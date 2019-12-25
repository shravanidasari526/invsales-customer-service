package com.invsales.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvsalesCustomerServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(InvsalesCustomerServiceApplication.class);
	
	public static void main(String[] args) {
		logger.info("<< App start - InvsalesCustomerServiceApplication");
		SpringApplication.run(InvsalesCustomerServiceApplication.class, args);
		logger.info(">> App End - InvsalesCustomerServiceApplication");
	}

}
