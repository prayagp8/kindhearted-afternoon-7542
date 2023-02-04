package com.tj.service;

import java.util.List;

import com.tj.exception.BookingException;
import com.tj.exception.BusException;
import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.exception.PaymentException;
import com.tj.model.PaymentDetails;

public interface PaymentService {
	
	public PaymentDetails payment(Integer bookingId) throws PackageException,PaymentException,BookingException,HotelException,BusException;
	
	public List<PaymentDetails> veiwAllPayments() throws PaymentException;
	

}
