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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.BookingException;
import com.tj.exception.BusException;
import com.tj.exception.CustomerException;
import com.tj.exception.FeedbackException;
import com.tj.exception.HotelException;
import com.tj.exception.LoginException;
import com.tj.exception.PackageException;
import com.tj.exception.PaymentException;
import com.tj.exception.RouteException;
import com.tj.exception.TicketException;
import com.tj.exception.TravelsException;

import com.tj.model.Booking;

import com.tj.model.Bus;

import com.tj.model.Customer;
import com.tj.model.Feedback;
import com.tj.model.Hotel;
import com.tj.model.LoginDTO;
import com.tj.model.Package;
import com.tj.model.PaymentDetails;
import com.tj.model.Route;
import com.tj.model.TicketDetails;

import com.tj.service.BookingService;
import com.tj.service.BusService;
import com.tj.service.CustomerLoginServiceImpl;
import com.tj.service.CustomerService;
import com.tj.service.FeedbackService;
import com.tj.service.HotelService;
import com.tj.service.PackageService;
import com.tj.service.PaymentService;
import com.tj.service.ReportService;
import com.tj.service.RouteService;


import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private FeedbackService feedbackService;



	@Autowired
	private CustomerService cService;







	@Autowired
	private PaymentService paymentService;





	@Autowired
	private CustomerLoginServiceImpl customerLoginServiceImpl;



	// for user login
	@PostMapping("/userlogin")
	public String loginCustomerr(@Valid @RequestBody LoginDTO customerDTO) throws Exception {
		return customerLoginServiceImpl.logIntoAccount(customerDTO);
	}

	// for user logout
	@PostMapping("/userlogout")
	public String logOutCustomerr(@RequestParam(required = false) String key) throws LoginException {
		return customerLoginServiceImpl.logOutFromAccount(key);
	}



	///////////////////////////Customer Controller Part

	@PostMapping("/")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) throws CustomerException {

		Customer c = cService.createCustomer(customer);

		return new ResponseEntity<Customer>(c, HttpStatus.OK);

	}

	@PutMapping("/{key}")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer costumer,
			@PathVariable("key") String key) throws CustomerException {

		Customer updateCu = cService.updateCustomer(costumer, key);

		return new ResponseEntity<>(updateCu, HttpStatus.OK);

	}


	@GetMapping("/all")
	public ResponseEntity<java.util.List<Customer>> getAllCustomer() throws CustomerException{

		java.util.List<Customer> customers=cService.allCustomer();

		return new ResponseEntity<java.util.List<Customer>>(customers,HttpStatus.OK);

	}
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) throws CustomerException{

		Customer customers=cService.viewCustomer(id);

		return new ResponseEntity<Customer>(customers,HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") Integer id) throws CustomerException{

		Customer customers=cService.deleteCustomerById(id);

		return new ResponseEntity<Customer>(customers,HttpStatus.OK);

	}



	///////////////////////////feedback Controller Part

	@GetMapping("/feedbackcustomer/{customerId}")
	public ResponseEntity<List<Feedback>> findByCustomerId(@PathVariable("customerId") Integer customerId)
			throws FeedbackException, CustomerException {

		List<Feedback> feedBacks = feedbackService.findByCustomerId(customerId);

		return new ResponseEntity<List<Feedback>>(feedBacks, HttpStatus.OK);

	}

	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> viewAllFeedbacks() throws FeedbackException {
		return new ResponseEntity<List<Feedback>>(feedbackService.viewAllFeedbacks(), HttpStatus.OK);
	}

	@PostMapping("/feedbacks/{customerId}")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback,
			@PathVariable("customerId") Integer customerId) throws FeedbackException, CustomerException {

		return new ResponseEntity<Feedback>(feedbackService.addFeedback(feedback, customerId), HttpStatus.ACCEPTED);
	}





}
