package com.invsales.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InvsalesCustomerServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(InvsalesCustomerServiceApplication.class);
	
	public static void main(String[] args) {
		logger.info("<< App start - InvsalesCustomerServiceApplication");
		SpringApplication.run(InvsalesCustomerServiceApplication.class, args);
		logger.info(">> App End - InvsalesCustomerServiceApplication");
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
