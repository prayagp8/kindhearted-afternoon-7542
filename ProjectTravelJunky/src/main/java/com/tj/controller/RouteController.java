package com.tj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.RouteException;
import com.tj.model.Route;
import com.tj.service.RouteService;

@RestController
public class RouteController {
	
	@Autowired
	private RouteService rService;
	
	public ResponseEntity<Route> addRoute(@RequestBody Route route) throws RouteException{
		
		 Route r = rService.addRoute(route);
		 
		 return new ResponseEntity<Route>(r,HttpStatus.OK);
		
	}

}
