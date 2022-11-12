package com.tj.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.model.Package;
import com.tj.exception.BookingException;
import com.tj.exception.PackageException;
import com.tj.model.Booking;
import com.tj.repository.BookingDAO;
import com.tj.repository.PackageDAO;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDAO bookingDAO;

	@Autowired
	private PackageDAO pDao;

	@Override
	public Booking makeBooking(Booking booking) throws BookingException {
		Booking newBooking = bookingDAO.save(booking);
		return newBooking;
	}

	@Override
	public Booking cancelBooking(Integer bookingId) throws BookingException {
		Optional<Booking> bookingOptional = bookingDAO.findById(bookingId);
		if (bookingOptional.isPresent()) {
			Booking booking = bookingOptional.get();
			bookingDAO.deleteById(bookingId);

			return booking;
		} else {
			throw new BookingException("Invalid Booking ID");
		}
	}

	@Override
	public Booking viewBooking(Integer bookingId) throws BookingException {
		Optional<Booking> bookingOptional = bookingDAO.findById(bookingId);
		if (bookingOptional.isPresent()) {
			Booking booking = bookingOptional.get();
			return booking;
		} else {
			throw new BookingException("Invalid Booking ID");
		}
	}

	@Override
	public List<Booking> viewAllBookings() throws BookingException {
		List<Booking> list = bookingDAO.findAll();
		if (list.size() == 0) {
			throw new BookingException("no booking is available!!");
		} else {
			return list;
		}
	}

	@Override
	public Package addPackage(Integer bid, Integer pid) throws BookingException, PackageException {

		Booking b = bookingDAO.findById(bid)
				.orElseThrow(() -> new BookingException("Booking Not Found By booking Id: " + bid));
		Package p = pDao.findById(pid)
				.orElseThrow(() -> new PackageException("Package Not avaleble With Package Id: " + pid));

		b.setPackages(p);
		p.setBooking(b);

		return pDao.save(p);

	}

}
