package com.tj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.BookingException;
import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.model.Booking;
import com.tj.model.Hotel;
import com.tj.model.Package;
import com.tj.repository.BookingDAO;
import com.tj.repository.HotelDAO;
import com.tj.repository.PackageDAO;
@Service
public class PackageServiceImpl implements PackageService{
	
	@Autowired
	private PackageDAO packageDAO;
	
	@Autowired
	private BookingDAO bookingDAO;
	
	@Autowired
	HotelDAO hotelDAO;


	@Override
	public Package deletePackage(Integer id) throws PackageException {
		Optional<Package> packageOptional= packageDAO.findById(id);
		if(packageOptional.isPresent()) {
			Package package1 = packageOptional.get();
			packageDAO.deleteById(id);
			return package1;
		}
		else {
			throw new PackageException("Invalid Package ID");
		}
	}

	@Override
	public Package searchPackage(Integer id) throws PackageException {
		Optional<Package> packageOptional= packageDAO.findById(id);
		if(packageOptional.isPresent()) {
			Package package1 = packageOptional.get();
			return package1;
		}
		else {
			throw new PackageException("Invalid Package ID");
		}
	}

	@Override
	public List<Package> viewAllPackage() throws PackageException {
		List<Package> list= packageDAO.findAll();
		if(list.size()==0) {
			throw new PackageException("no package is available!!");
		}
		else {
			return list;
		}
	}

	@Override
	public Booking addPackageToBooking(Integer bId, Integer pId) throws PackageException, BookingException {
		Optional<Package> packageOptional= packageDAO.findById(pId);
		if(packageOptional.isPresent()) {
			Package package1 = packageOptional.get();
			Booking b = bookingDAO.findById(bId).orElseThrow(()->new BookingException("Invalid booking ID!"));
//			package1.setBooking(b);
			package1.setPackageCost(package1.getHotel().getHotelPrice()*package1.getNoOfDays());
			b.setPackages(package1);
			
			
			return bookingDAO.save(b);
		}
		else {
			throw new PackageException("Invalid Package ID");
		}
	}

	@Override
	public Package registerPackage(Package package1) throws PackageException {
		
		return packageDAO.save(package1);
	}

	@Override
	public Package addHotelToPackage(Integer hotelId, Integer pkgId) throws PackageException, HotelException {
		Optional<Package> packageOptional= packageDAO.findById(pkgId);
		if(packageOptional.isPresent()) {
			Hotel h = hotelDAO.findById(hotelId).orElseThrow(()->new HotelException("Invalid hotel Id!!"));
			Package package1 = packageOptional.get();
			package1.setHotel(h);
			return packageDAO.save(package1);
		}
		else {
			throw new PackageException("Invalid Package ID");
		}
	}
	
	

}
