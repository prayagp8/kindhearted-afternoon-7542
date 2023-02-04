package com.tj.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	
//	@Pattern(regexp = "^[a-zA-Z0-9_ ]*$",message = "Booking type cannot start with number of symbol")
//	private String bookingType;
//	private String description;
	

//	@Pattern(regexp = "^[a-zA-Z0-9_ ]*$",message = "Title cannot start with number of symbol")
//	private String bookingTitle;
	
	private LocalDate bookingDate;
	
	private Double bookingAmt;
	
	private String status;
	
//	@JsonIgnore
	@OneToOne
	private Package packages;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;


	public Booking() {
		// TODO Auto-generated constructor stub
	}


	public Integer getBookingId() {
		return bookingId;
	}


	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}


	public LocalDate getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}


	public Double getBookingAmt() {
		return bookingAmt;
	}


	public void setBookingAmt(Double bookingAmt) {
		this.bookingAmt = bookingAmt;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Package getPackages() {
		return packages;
	}


	public void setPackages(Package packages) {
		this.packages = packages;
	}




	public Bus getBus() {
		return bus;
	}


	public void setBus(Bus bus) {
		this.bus = bus;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Booking(Integer bookingId, LocalDate bookingDate, Double bookingAmt, String status, Package packages,
			Customer customer, Bus bus) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookingAmt = bookingAmt;
		this.status = status;
		this.packages = packages;
		this.customer = customer;
		this.bus = bus;
	}



	
		




	


	
	
}
