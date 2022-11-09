package com.tj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.CustomerException;
import com.tj.model.Customer;
import com.tj.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;

	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws CustomerException {
		
		 Customer c = cService.createCustomer(customer);
		 
		 return new ResponseEntity<Customer>(c,HttpStatus.OK);
		
	}
}
