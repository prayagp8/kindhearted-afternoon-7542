package com.tj.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Package {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer packageId;
	
	@NotNull
	private String packageName;
	private String packageDescription;
	private String packageType;
	
	@NotNull
	private Double packageCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Booking booking;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Hotel hotel;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private TicketDetails ticketDetails;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentDetails payment;
	
	public Package() {
		// TODO Auto-generated constructor stub
	}

	

	public PaymentDetails getPayment() {
		return payment;
	}



	public void setPayment(PaymentDetails payment) {
		this.payment = payment;
	}



	public Package(String packageName, String packageDescription, String packageType, Double packageCost,
			Booking booking, Hotel hotel, TicketDetails ticketDetails, PaymentDetails payment) {
		super();
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageType = packageType;
		this.packageCost = packageCost;
		this.booking = booking;
		this.hotel = hotel;
		this.ticketDetails = ticketDetails;
		this.payment = payment;
	}



	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public Double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(Double packageCost) {
		this.packageCost = packageCost;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public TicketDetails getTicketDetails() {
		return ticketDetails;
	}

	public void setTicketDetails(TicketDetails ticketDetails) {
		this.ticketDetails = ticketDetails;
	}
	
	
}
