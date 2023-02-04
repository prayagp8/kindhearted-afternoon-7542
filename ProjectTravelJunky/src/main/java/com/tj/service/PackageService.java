package com.tj.service;

import java.util.List;

import com.tj.exception.BookingException;
import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.model.Booking;
import com.tj.model.Package;

public interface PackageService {
	public Booking addPackageToBooking(Integer bId,Integer pId)throws PackageException,BookingException;
	public Package addHotelToPackage(Integer hotelId,Integer pkgId)throws PackageException,HotelException;
	public Package registerPackage(Package package1)throws PackageException;
	public Package deletePackage(Integer id)throws PackageException;
	public Package searchPackage(Integer id)throws PackageException;
	public List<Package> viewAllPackage()throws PackageException;
}
