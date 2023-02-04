package com.tj.service;

import java.util.List;

import com.tj.exception.BookingException;
import com.tj.exception.BusException;
import com.tj.exception.CustomerException;
import com.tj.exception.PackageException;
import com.tj.model.Booking;
import com.tj.model.Package;

public interface BookingService {
	public Booking makeBooking(Integer userId)throws BookingException,CustomerException;
	public Booking cancelBooking(Integer bookingId)throws BookingException;
	public Booking viewBooking(Integer bookingId)throws BookingException;
	public List<Booking> viewAllBookings()throws BookingException;
	public Package addPackage(Integer bid,Integer pid) throws BookingException,PackageException;
	
	public Booking addBusToBooking(Integer busId,Integer BookingId)throws BusException,BookingException;

	
}
