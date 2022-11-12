package com.tj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.BookingException;
import com.tj.exception.PackageException;
import com.tj.model.Booking;
import com.tj.model.Package;
import com.tj.repository.PackageDAO;
@Service
public class PackageServiceImpl implements PackageService{
	
	@Autowired
	private PackageDAO packageDAO;

	@Override
	public Package addPackage(Package package1) throws PackageException {
		Package package2 = packageDAO.save(package1);
		return package2;
	}

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
	
	

}
