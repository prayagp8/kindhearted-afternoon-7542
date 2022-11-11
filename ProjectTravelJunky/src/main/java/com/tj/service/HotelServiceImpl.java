package com.tj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.HotelException;
import com.tj.model.Hotel;
import com.tj.repository.HotelDAO;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelDAO hotelDAO;

	@Override
	public Hotel addHotel(Hotel hotel) throws HotelException {
		Hotel hotel2 = hotelDAO.save(hotel);
		if (hotel2 == null) {
			throw new HotelException("Hotel can not be added.");
		}
		return hotel2;
	}

	@Override
	public Hotel deleteHotel(Integer hotelId) throws HotelException {
		Optional<Hotel> opt = hotelDAO.findById(hotelId);
		if (opt == null) {
			throw new HotelException("Hotel can not be deleted.");
		}
		Hotel hotel = opt.get();
		hotelDAO.delete(hotel);
		return hotel;
	}

	@Override
	public Hotel findByHotelId(Integer hotelId) throws HotelException {
		Optional<Hotel> opt = hotelDAO.findById(hotelId);
		if (opt == null) {
			throw new HotelException("Hotel does not exists with Hotel Id : " + hotelId);
		}
		return opt.get();
	}

	@Override
	public List<Hotel> viewAllHotels() throws HotelException {
		List<Hotel> reports = hotelDAO.findAll();
		if (reports.isEmpty()) {
			throw new HotelException("No Hotel exists.");
		}
		return reports;
	}

}
