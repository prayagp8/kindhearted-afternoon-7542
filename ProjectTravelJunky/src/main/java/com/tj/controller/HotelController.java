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
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.model.Hotel;
import com.tj.model.Package;
import com.tj.service.HotelService;


@RestController
@RequestMapping("/hotel")
public class HotelController {


	@Autowired
	private HotelService hotelService;
	

	

	@GetMapping("/{hId}/{pId}")
	public ResponseEntity<Package> addPackage(@PathVariable("hId") Integer hotelId, @PathVariable("pId") Integer packageId) throws HotelException, PackageException{

		Package p = hotelService.addPackage(hotelId, packageId);

		return new ResponseEntity<Package>(p,HttpStatus.OK);
	}

	@DeleteMapping("/{hotelId}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable("hotelId") Integer hotelId) throws HotelException {
		return new ResponseEntity<Hotel>(hotelService.deleteHotel(hotelId), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) throws HotelException {
		Hotel h = hotelService.addHotel(hotel);
		return new ResponseEntity<Hotel>(h, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> findByHotelId(@PathVariable("hotelId") Integer hotelId) throws HotelException {
		return new ResponseEntity<Hotel>(hotelService.findByHotelId(hotelId), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Hotel>> viewAllHotels() throws HotelException{
		return new ResponseEntity<List<Hotel>>(hotelService.viewAllHotels(),HttpStatus.OK);
	};






}
