package com.tj.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.tj.exception.BusException;


import com.tj.exception.RouteException;

import com.tj.model.Bus;

import com.tj.model.Route;


import com.tj.service.BusService;

import com.tj.service.RouteService;


@RestController
@RequestMapping("/route")
public class RouteController {

	@Autowired
	private RouteService rService;
	@Autowired
	private BusService busService;

	@PostMapping("/add")
	public ResponseEntity<Bus> addRouteServices(@RequestParam Integer busId,
			@RequestParam Integer routeId) throws BusException, RouteException {
		Bus r = busService.addRouteServices(busId, routeId);
		return new ResponseEntity<Bus>(r, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route) throws RouteException {

		Route r = rService.addRoute(route);

		return new ResponseEntity<Route>(r, HttpStatus.OK);

	}



	@PutMapping("/")
	public ResponseEntity<Route> updateRoute(@Valid @RequestBody Route route) throws RouteException {
		Route r = rService.updateRoute(route);
		return new ResponseEntity<Route>(r, HttpStatus.OK);
	}

	@DeleteMapping("/{routeId}")
	public ResponseEntity<Route> removeRoute(@PathVariable("routeId") Integer routeId) throws RouteException {
		Route r = rService.removeRoute(routeId);
		return new ResponseEntity<Route>(r, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Route>> viewRouteList() throws RouteException{
		List<Route> routeList = rService.viewRouteList();
		return new ResponseEntity<List<Route>>(routeList,HttpStatus.OK);

	}


	

	
	@GetMapping("/{id}")
	public ResponseEntity<Route> searchRoute(@PathVariable("id")Integer routeId) throws RouteException{
		
		Route r = rService.searchRoute(routeId);
		return new ResponseEntity<Route>(r,HttpStatus.OK);
	}
	
	
	
	
}
