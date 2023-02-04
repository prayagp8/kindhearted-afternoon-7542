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

	
	@NotNull
	private Double packageCost;
	
	private Integer NoOfDays;
	
	private Integer pax;
	
//	@JsonIgnore
//	@OneToOne(cascade = CascadeType.ALL)
//	private Booking booking;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Hotel hotel;

	

	public Package() {
		// TODO Auto-generated constructor stub
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



	public Double getPackageCost() {
		return packageCost;
	}



	public void setPackageCost(Double packageCost) {
		this.packageCost = packageCost;
	}



	public Integer getNoOfDays() {
		return NoOfDays;
	}



	public void setNoOfDays(Integer noOfDays) {
		NoOfDays = noOfDays;
	}



	public Integer getPax() {
		return pax;
	}



	public void setPax(Integer pax) {
		this.pax = pax;
	}







	public Hotel getHotel() {
		return hotel;
	}



	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}



	public Package(Integer packageId,String packageName, String packageDescription,
			Double packageCost, Integer noOfDays, Integer pax, Booking booking, Hotel hotel) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageCost = packageCost;
		NoOfDays = noOfDays;
		this.pax = pax;
		
		this.hotel = hotel;
	}
	
	





	
	
}
