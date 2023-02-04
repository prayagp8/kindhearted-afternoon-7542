package com.tj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.BookingException;
import com.tj.exception.BusException;
import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.exception.PaymentException;
import com.tj.model.PaymentDetails;
import com.tj.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/{bId}")
	public ResponseEntity<PaymentDetails> payment(@PathVariable("bId") Integer bookingId) throws PackageException,PaymentException,BookingException,HotelException,BusException{
		return new ResponseEntity<PaymentDetails>(paymentService.payment(bookingId),HttpStatus.ACCEPTED);
	};

}
