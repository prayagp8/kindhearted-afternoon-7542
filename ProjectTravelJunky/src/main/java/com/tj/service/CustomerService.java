package com.tj.service;

import java.util.List;

import com.tj.exception.CustomerException;
import com.tj.model.Customer;

public interface CustomerService {
	
	public Customer createCustomer(Customer customer) throws CustomerException;
	public Customer updateCustomer(Customer customer, String key) throws CustomerException;
	public List<Customer> allCustomer() throws CustomerException;


}
