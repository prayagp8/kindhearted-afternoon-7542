package com.tj.service;

import java.util.List;

import com.tj.exception.HotelException;
import com.tj.model.Hotel;

public interface HotelService {

	public Hotel addHotel(Hotel hotel) throws HotelException;

	public Hotel deleteHotel(Integer hotelId) throws HotelException;

	public Hotel findByHotelId(Integer hotelId) throws HotelException;

	public List<Hotel> viewAllHotels() throws HotelException;
}
