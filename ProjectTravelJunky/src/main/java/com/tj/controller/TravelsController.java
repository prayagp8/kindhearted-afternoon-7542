package com.tj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.TravelsException;
import com.tj.model.Travels;
import com.tj.service.TravelsService;

@RestController
@RequestMapping("/travels")
public class TravelsController {

	@Autowired
	private TravelsService tservice;

	@GetMapping("/search/{id}")
	public ResponseEntity<Travels> searchTravels(@PathVariable("id") Integer id) throws TravelsException {

		Travels t = tservice.searchTravels(id);

		return new ResponseEntity<Travels>(t, HttpStatus.OK);

	}

	@GetMapping("/view")
	public ResponseEntity<List<Travels>> viewTravels() throws TravelsException {

		List<Travels> list = tservice.viewTravels();
		return new ResponseEntity<List<Travels>>(list, HttpStatus.OK);

	}

}
