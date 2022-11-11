package com.tj.service;

import java.util.List;

import com.tj.exception.BookingException;
import com.tj.exception.PackageException;
import com.tj.model.Booking;

public interface BookingService {
	public Booking makeBooking(Booking booking)throws BookingException;
	public Booking cancelBooking(Integer bookingId)throws BookingException;
	public Booking viewBooking(Integer bookingId)throws BookingException;
	public List<Booking> viewAllBookings()throws BookingException;
	public com.tj.model.Package addPackage(Integer bid,Integer pid) throws BookingException,PackageException;

	
}
