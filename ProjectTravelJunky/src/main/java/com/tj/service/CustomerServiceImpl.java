package com.tj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.CustomerException;
import com.tj.model.Customer;
import com.tj.model.currentUserSession;
import com.tj.repository.CustomerDao;
import com.tj.repository.SessionDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao cDao;

	@Autowired
	private SessionDao sDao;

	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {

		
		Customer exsistingcustomer = cDao.findByMobileNo(customer.getMobileNo());

		if (exsistingcustomer != null) {
			throw new CustomerException("customer already registerd with mobile number!!");
		}

		return cDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		currentUserSession loggedInUser = sDao.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("please provide the valid key to update the customer!!");
		}

		if (customer.getCustomerId() == loggedInUser.getUserId()) {
			return cDao.save(customer);
		} else {
			throw new CustomerException("invalid customer details, please login first!!");
		}

	}

	@Override
	public List<Customer> allCustomer() throws CustomerException {
		List<Customer> customer = cDao.findAll();
		if (customer.size() == 0) {
			throw new CustomerException("No customer in database");
		} else {
			return customer;
		}
	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerException {

		Optional<Customer> getCustomer = cDao.findById(customer.getCustomerId());

		if (getCustomer.isPresent()) {

			cDao.deleteById(customer.getCustomerId());
			return getCustomer.get();
		}
		throw new CustomerException("Customer Not Found");
	}

	@Override
	public Customer viewCustomer(Integer cid) throws CustomerException {

		Optional<Customer> findCus = cDao.findById(cid);

		if (findCus.isPresent()) {
			return findCus.get();
		} else {
			throw new CustomerException("Customer not avalible with Id: " + cid);
		}
	}

	@Override
	public Customer deleteCustomerById(Integer id) throws CustomerException {
		Optional<Customer> getCustomer = cDao.findById(id);

		if (getCustomer.isPresent()) {

			cDao.deleteById(id);
			return getCustomer.get();
		}
		throw new CustomerException("Customer Not Found with Id: "+id);
	}

}
