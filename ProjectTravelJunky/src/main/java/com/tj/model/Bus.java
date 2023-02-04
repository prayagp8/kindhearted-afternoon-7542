package com.tj.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;



@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId;
	
	
	private String busType;
	
	@NotNull
	private String busNumber;
	
	@NotNull
	private Integer capacity;
	
	private Integer fare;

	@OneToOne
	private Route route;
	

	
	public Bus() {

	}


	public Bus(Integer busId, String busType, @NotNull String busNumber, @NotNull Integer capacity, Integer fare) {
		super();
		this.busId = busId;
		this.busType = busType;
		this.busNumber = busNumber;
		this.capacity = capacity;
		this.fare = fare;
	}


	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}



	public Integer getFare() {
		return fare;
	}


	public void setFare(Integer fare) {
		this.fare = fare;
	}


	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busType=" + busType + ", busNumber=" + busNumber + ", capacity=" + capacity
				+ ", route=" + route +"]";
	}

}
