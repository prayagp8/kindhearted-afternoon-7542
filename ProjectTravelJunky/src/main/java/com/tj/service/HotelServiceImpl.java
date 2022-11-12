package com.tj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.model.Hotel;
import com.tj.repository.HotelDAO;
import com.tj.repository.PackageDAO;
import com.tj.model.Package;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelDAO hotelDAO;
	@Autowired
	private PackageDAO pDao;

	@Override
	public Hotel addHotel(Hotel hotel) throws HotelException {

		return hotelDAO.save(hotel);
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
		if (opt.isPresent()) {
			return opt.get();
		}else {
			throw new HotelException("Hotel does not exists with Hotel Id : " + hotelId);
		}

	}

	@Override
	public List<Hotel> viewAllHotels() throws HotelException {
		List<Hotel> reports = hotelDAO.findAll();
		if (reports.size()==0) {
			throw new HotelException("No Hotel exists.");
		}else {
			return reports;
		}

	}

	@Override
	public Package addPackage(Integer hoteId, Integer packageId) throws HotelException, PackageException {
		Hotel h = hotelDAO.findById(hoteId).orElseThrow(()->new HotelException("hotel doesn't found with this hotel id : "+hoteId));
		Package p = pDao.findById(packageId).orElseThrow(()->new PackageException("package doesn't found with this package id : "+packageId));

		p.setHotel(h);
		h.setPackages(p);
		
		return pDao.save(p);

	}

}
