package com.tj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.BookingException;
import com.tj.exception.BusException;
import com.tj.exception.CustomerException;
import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.model.Booking;
import com.tj.model.Package;
import com.tj.service.AdminLoginServiceImpl;
import com.tj.service.AdminService;
import com.tj.service.BookingService;
import com.tj.service.BusService;
import com.tj.service.CustomerService;
import com.tj.service.FeedbackService;
import com.tj.service.HotelService;
import com.tj.service.PackageService;
import com.tj.service.PaymentService;
import com.tj.service.ReportService;
import com.tj.service.RouteService;


@RestController
@RequestMapping("/booking")
public class BookingController {


	@Autowired
	private BookingService bookingService;

	


	@Autowired
	private RouteService rService;


	@DeleteMapping("/{id}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable("id") Integer id) throws BookingException{
		Booking booking= bookingService.cancelBooking(id);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}


	@GetMapping("/{id}")
	public ResponseEntity<Booking> viewBooking(@PathVariable("id") Integer id) throws BookingException{
		Booking booking= bookingService.viewBooking(id);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Booking>> viewAllBooking() throws BookingException{
		List<Booking> list = bookingService.viewAllBookings();
		return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
	}
	
	
	


	
	@PostMapping("/add")
	public ResponseEntity<Package> addPackage(@RequestParam Integer bid,@RequestParam Integer pid) throws PackageException, BookingException{
		Package package2=bookingService.addPackage(bid, pid);
		return new ResponseEntity<Package>(package2, HttpStatus.CREATED);
	}
	
	@PostMapping("/{userId}")
	public ResponseEntity<Booking> makeBooking( @PathVariable("userId") Integer userId) throws BookingException, CustomerException{
		Booking newBooking=bookingService.makeBooking(userId);
		return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/bus")
	public ResponseEntity<Booking> addBusToBooking(@RequestParam Integer busId,@RequestParam Integer BookingId)throws BusException,BookingException{
		return new ResponseEntity<Booking>(bookingService.addBusToBooking(busId, BookingId),HttpStatus.OK);
	};
	

	

	
	
	
}
