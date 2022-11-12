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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.BookingException;
import com.tj.exception.PackageException;
import com.tj.model.Booking;
import com.tj.model.Package;
import com.tj.service.BookingService;
import com.tj.service.PackageService;

@RestController
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private PackageService packageService;
	
	@PostMapping("/makebooking")
	public ResponseEntity<Booking> makeBooking(@Valid @RequestBody Booking booking) throws BookingException{
		Booking newBooking=bookingService.makeBooking(booking);
		return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/cancelbooking/{id}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable("id") Integer id) throws BookingException{
		Booking booking= bookingService.cancelBooking(id);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}
	
	@GetMapping("/viewbooking/{id}")
	public ResponseEntity<Booking> viewBooking(@PathVariable("id") Integer id) throws BookingException{
		Booking booking= bookingService.viewBooking(id);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}
	
	@GetMapping("/allBookings")
	public ResponseEntity<List<Booking>> viewAllBooking() throws BookingException{
		List<Booking> list = bookingService.viewAllBookings();
		return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/addpackage/{bid}/{pid}")
	public ResponseEntity<Package> addPackage(@PathVariable("bid")Integer bid,@PathVariable("pid")Integer pid) throws PackageException, BookingException{
		Package package2=bookingService.addPackage(bid, pid);
		return new ResponseEntity<Package>(package2, HttpStatus.CREATED);
	}
	
	
}
