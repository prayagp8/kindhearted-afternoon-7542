package com.tj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.BookingException;
import com.tj.model.Booking;
import com.tj.repository.BookingDAO;
@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingDAO bookingDAO;

	@Override
	public Booking makeBooking(Booking booking) throws BookingException {
		Booking newBooking = bookingDAO.save(booking);
		return newBooking;
	}

	@Override
	public Booking cancelBooking(Integer bookingId) throws BookingException {
		Optional<Booking> bookingOptional= bookingDAO.findById(bookingId);
		if(bookingOptional.isPresent()) {
			bookingDAO.deleteById(bookingId);
			Booking booking = bookingOptional.get();
			return booking;
		}
		else {
			throw new BookingException("Invalid Booking ID");
		}
	}

	@Override
	public Booking viewBooking(Integer bookingId) throws BookingException {
		Optional<Booking> bookingOptional= bookingDAO.findById(bookingId);
		if(bookingOptional.isPresent()) {
			Booking booking = bookingOptional.get();
			return booking;
		}
		else {
			throw new BookingException("Invalid Booking ID");
		}
	}

	@Override
	public List<Booking> viewAllBookings() throws BookingException {
		List<Booking> list= bookingDAO.findAll();
		if(list.size()==0) {
			throw new BookingException();
		}
		else {
			return list;
		}
	}

}
