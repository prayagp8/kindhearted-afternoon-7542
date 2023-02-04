package com.tj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;





@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hotelId;
	
	@NotNull
	private String hotelName;
	@NotNull
	private String address;
	private String rating;
	private Integer AvailableRooms;
	
	
	private Double hotelPrice;
	
	private String status;




	public Hotel() {
		// TODO Auto-generated constructor stub
	}




	public Integer getHotelId() {
		return hotelId;
	}




	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}




	public String getHotelName() {
		return hotelName;
	}




	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getRating() {
		return rating;
	}




	public void setRating(String rating) {
		this.rating = rating;
	}




	public Integer getAvailableRooms() {
		return AvailableRooms;
	}




	public void setAvailableRooms(Integer availableRooms) {
		AvailableRooms = availableRooms;
	}




	public Double getHotelPrice() {
		return hotelPrice;
	}




	public void setHotelPrice(Double hotelPrice) {
		this.hotelPrice = hotelPrice;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public Hotel(Integer hotelId, String hotelName, String address, String rating, Integer availableRooms,
			Double hotelPrice, String status) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.address = address;
		this.rating = rating;
		AvailableRooms = availableRooms;
		this.hotelPrice = hotelPrice;
		this.status = status;
	}
	
	
	
	
	
	
	
	


	
	
}
