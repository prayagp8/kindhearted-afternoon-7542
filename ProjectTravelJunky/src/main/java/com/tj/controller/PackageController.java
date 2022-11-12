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
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.BookingException;
import com.tj.exception.PackageException;
import com.tj.model.Booking;
import com.tj.model.Package;
import com.tj.service.PackageService;

@RestController
public class PackageController {
	@Autowired
	private PackageService packageService;
	
	@PostMapping("/addpackage")
	public ResponseEntity<Package> addPackage(@Valid @RequestBody Package package1) throws PackageException{
		Package package2=packageService.addPackage(package1);
		return new ResponseEntity<Package>(package2, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletepackage/{id}")
	public ResponseEntity<Package> deletePackage(@PathVariable("id") Integer id) throws PackageException{
		Package package1= packageService.deletePackage(id);
		return new ResponseEntity<Package>(package1,HttpStatus.OK);
	}
	
	@GetMapping("/viewpackage/{id}")
	public ResponseEntity<Package> viewPackage(@PathVariable("id") Integer id) throws PackageException{
		Package package1= packageService.searchPackage(id);
		return new ResponseEntity<Package>(package1,HttpStatus.OK);
	}

	@GetMapping("/allpackage")
	public ResponseEntity<List<Package>> viewAllPackage() throws PackageException{
		List<Package> list = packageService.viewAllPackage();
		return new ResponseEntity<List<Package>>(list,HttpStatus.OK);
	}
}
