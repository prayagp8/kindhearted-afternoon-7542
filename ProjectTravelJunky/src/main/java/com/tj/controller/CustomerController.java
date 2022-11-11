package com.tj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.CustomerException;
import com.tj.model.Customer;
import com.tj.service.CustomerService;

import antlr.collections.List;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;

	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws CustomerException {
		
		 Customer c = cService.createCustomer(customer);
		 
		 return new ResponseEntity<Customer>(c,HttpStatus.OK);
		
	}
	
	@PutMapping("/customers/{key}")
	public ResponseEntity<Customer> updateCustomerDetailsHandler(@RequestBody Customer costumer,@PathVariable("key") String key) throws CustomerException{
		
		Customer updateCu= cService.updateCustomer(costumer, key);
		
		return new ResponseEntity<>(updateCu,HttpStatus.OK);
		
	}
	
	@GetMapping("/customers")
	public ResponseEntity<java.util.List<Customer>> getAllCustomer() throws CustomerException{
		
		java.util.List<Customer> customers=cService.allCustomer();
		
		return new ResponseEntity<java.util.List<Customer>>(customers,HttpStatus.OK);
		
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) throws CustomerException{
		
		Customer customers=cService.viewCustomer(id);
		
		return new ResponseEntity<Customer>(customers,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") Integer id) throws CustomerException{
		
		Customer customers=cService.deleteCustomerById(id);
		
		return new ResponseEntity<Customer>(customers,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/customers")
	public ResponseEntity<Customer> deleteCustomerByCustomer(@RequestBody Customer customer) throws CustomerException{
		
		Customer customers=cService.deleteCustomer(customer);
		
		return new ResponseEntity<Customer>(customers,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/test")
	public String test() {
		
		return "Success..";
	}
}
