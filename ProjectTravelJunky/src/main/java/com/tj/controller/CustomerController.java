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
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.CustomerException;
import com.tj.exception.RouteException;
import com.tj.exception.TravelsException;
import com.tj.model.Customer;
import com.tj.model.Route;
import com.tj.model.Travels;
import com.tj.service.CustomerService;
import com.tj.service.RouteService;
import com.tj.service.TravelsService;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService cService;

	@Autowired
	private TravelsService tservice;
	
	@Autowired
	private RouteService rService;

///////////////////////////Customer Controller Part

	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) throws CustomerException {

		Customer c = cService.createCustomer(customer);

		return new ResponseEntity<Customer>(c, HttpStatus.OK);

	}

	@PutMapping("/customers/{key}")
	public ResponseEntity<Customer> updateCustomerDetailsHandler(@Valid @RequestBody Customer costumer,
			@PathVariable("key") String key) throws CustomerException {

		Customer updateCu = cService.updateCustomer(costumer, key);

		return new ResponseEntity<>(updateCu, HttpStatus.OK);

	}

///////////////////////////Travel Controller Part
	@GetMapping("/travel/search/{id}")
	public ResponseEntity<Travels> searchTravels(@PathVariable("id") Integer id) throws TravelsException {

		Travels t = tservice.searchTravels(id);

		return new ResponseEntity<Travels>(t, HttpStatus.OK);

	}

	@GetMapping("/travel/view")
	public ResponseEntity<List<Travels>> viewTravels() throws TravelsException {

		List<Travels> list = tservice.viewTravels();
		return new ResponseEntity<List<Travels>>(list, HttpStatus.OK);

	}
	
///////////////////////////Route Controller Part
	
	@GetMapping("/route/routes")
	public ResponseEntity<List<Route>> viewRouteList() throws RouteException{
		List<Route> routeList = rService.viewRouteList();
		return new ResponseEntity<List<Route>>(routeList,HttpStatus.OK);
		
	}
	
	@GetMapping("/route/routesbyid/{id}")
	public ResponseEntity<Route> searchRoute(@PathVariable("id")Integer routeId) throws RouteException{
		
		Route r = rService.searchRoute(routeId);
		return new ResponseEntity<Route>(r,HttpStatus.OK);
	}


}
