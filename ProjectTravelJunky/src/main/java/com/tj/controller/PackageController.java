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
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.BookingException;
import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.exception.PaymentException;
import com.tj.exception.TicketException;
import com.tj.model.Booking;
import com.tj.model.Package;
import com.tj.model.PaymentDetails;
import com.tj.model.TicketDetails;
import com.tj.repository.PaymentDao;
import com.tj.service.PackageService;
import com.tj.service.PaymentService;
import com.tj.service.TicketService;

@RestController
public class PackageController {
	@Autowired
	private PackageService packageService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/addpackage")
	public ResponseEntity<Package> addPackage(@RequestBody Package package1) throws PackageException{
		Package package2=packageService.addPackage(package1);
		return new ResponseEntity<Package>(package2, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletepackage/{id}")
	public ResponseEntity<Package> deletePackage(@PathVariable("id") Integer id) throws PackageException{
		Package package1= packageService.deletePackage(id);
		return new ResponseEntity<Package>(package1,HttpStatus.OK);
	}
	
	@GetMapping("/viewpackage/{id}")
	public ResponseEntity<Package> viewPackage(@PathVariable("id") Integer id) throws PackageException{
		Package package1= packageService.searchPackage(id);
		return new ResponseEntity<Package>(package1,HttpStatus.OK);
	}

	@GetMapping("/allpackage")
	public ResponseEntity<List<Package>> viewAllPackage() throws PackageException{
		List<Package> list = packageService.viewAllPackage();
		return new ResponseEntity<List<Package>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/payment/{pId}/{bId}/{hId}")
	public ResponseEntity<PaymentDetails> payment(@RequestBody PaymentDetails paymentD ,@PathVariable("pId") Integer packageId, @PathVariable("bId") Integer bookingId, @PathVariable("hId") Integer hotelId) throws PackageException, PaymentException, BookingException, HotelException {
		PaymentDetails payment  = paymentService.payment(paymentD, packageId, bookingId, hotelId);
		
		return new ResponseEntity<PaymentDetails>(payment,HttpStatus.ACCEPTED);
		
		
	}
	
	@PostMapping("ticket/{paymentId}")
	public ResponseEntity<TicketDetails> addticket(@RequestBody TicketDetails ticket, @PathVariable("paymentId") Integer paymentId) throws TicketException, PaymentException{
		
		TicketDetails t = ticketService.addticket(ticket, paymentId);
		
		return new ResponseEntity<TicketDetails>(t,HttpStatus.OK);
		
	}
	
	@GetMapping("/ticket")
	public ResponseEntity<List<TicketDetails>> viewAllTicket() throws TicketException{
		 List<TicketDetails> tList= ticketService.viewAllTicket();
		 
		 return new ResponseEntity<List<TicketDetails>>(tList,HttpStatus.OK);
	}
	
	@DeleteMapping("/ticket/{tId}")
	public ResponseEntity<TicketDetails> deleteTicket(@PathVariable("tId") Integer ticketId) throws TicketException {
		
		TicketDetails t = ticketService.deleteTicket(ticketId);
		
		return new ResponseEntity<TicketDetails>(t,HttpStatus.OK);
	}
	
	@GetMapping("/payement")
	public ResponseEntity<List<PaymentDetails>> veiwAllPayments() throws PaymentException{
		List<PaymentDetails> pList = paymentService.veiwAllPayments();
		return new ResponseEntity<List<PaymentDetails>>(pList,HttpStatus.OK);
	}
}
