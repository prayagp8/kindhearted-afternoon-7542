package com.tj.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.HotelException;
import com.tj.model.Hotel;
import com.tj.service.HotelService;

@RestController
public class HotelController {

	private HotelService hotelService;

	@PostMapping("/hotels")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel) throws HotelException {
		return new ResponseEntity<Hotel>(hotelService.addHotel(hotel), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/hotels/{hotelId}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable("hotelId") Integer hotelId) throws HotelException {
		return new ResponseEntity<Hotel>(hotelService.deleteHotel(hotelId), HttpStatus.OK);
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<Hotel> findByReportId(@PathVariable("hotelId") Integer hotelId) throws HotelException {
		return new ResponseEntity<Hotel>(hotelService.findByHotelId(hotelId), HttpStatus.OK);
	}

	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> viewAllReports() throws HotelException {
		return new ResponseEntity<List<Hotel>>(hotelService.viewAllHotels(), HttpStatus.OK);
	}

}
