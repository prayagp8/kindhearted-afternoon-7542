package com.tj.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.BookingException;
import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.model.Booking;
import com.tj.model.Package;

import com.tj.service.PackageService;


@RestController
@RequestMapping("/package")
public class PackageController {




	@Autowired
	private PackageService packageService;
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Package>> viewAllPackage() throws PackageException{
		List<Package> list = packageService.viewAllPackage();
		return new ResponseEntity<List<Package>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{pid}")
	public ResponseEntity<Package> viewPackage(@PathVariable("pid") Integer id) throws PackageException{
		Package package1= packageService.searchPackage(id);
		return new ResponseEntity<Package>(package1,HttpStatus.OK);
	}
	
	@PostMapping("/addHotel")
	public ResponseEntity<Package> addHotelToPackage(@RequestParam Integer hotelId,@RequestParam Integer pkgId)throws PackageException,HotelException{
		return new ResponseEntity<Package>(packageService.addHotelToPackage(hotelId, pkgId),HttpStatus.OK);
	};


	@PostMapping("/")
	public ResponseEntity<Package> addPackage(@Valid @RequestBody Package package1) throws PackageException{
		Package package2=packageService.registerPackage(package1);
		return new ResponseEntity<Package>(package2, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Package> deletePackage(@PathVariable("id") Integer id) throws PackageException{
		Package package1= packageService.deletePackage(id);
		return new ResponseEntity<Package>(package1,HttpStatus.OK);
	}
	
	@PostMapping("/book")
	public ResponseEntity<Booking> addPackageToBooking(@RequestParam Integer bId,@RequestParam Integer pId)throws PackageException,BookingException{
		return new ResponseEntity<Booking>(packageService.addPackageToBooking(bId, pId),HttpStatus.OK);
	};






}
