package com.tj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.BookingException;
import com.tj.model.Booking;
import com.tj.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/makebooking")
	public ResponseEntity<Booking> makeBooking(@RequestBody Booking booking) throws BookingException{
		Booking newBooking=bookingService.makeBooking(booking);
		return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);
	}
	
	@GetMapping("/cancelbooking/{id}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable("id") Integer id) throws BookingException{
		Booking booking= bookingService.cancelBooking(id);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}
	
	@GetMapping("/viewbooking/{id}")
	public ResponseEntity<Booking> viewBooking(@PathVariable("id") Integer id) throws BookingException{
		Booking booking= bookingService.cancelBooking(id);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}
	
	@GetMapping("/allBookings")
	public ResponseEntity<List<Booking>> viewAllBooking() throws BookingException{
		List<Booking> list = bookingService.viewAllBookings();
		return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
	}
	
}
