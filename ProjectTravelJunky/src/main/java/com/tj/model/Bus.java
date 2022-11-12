package com.tj.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Route route;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private currentUserSession currenUserSession;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Travels travels;
	
	public Bus() {

	}

	public Bus(Integer busId, String busType, String busNumber, Integer capacity, Route route) {
		super();
		this.busId = busId;
		this.busType = busType;
		this.busNumber = busNumber;
		this.capacity = capacity;
		this.route = route;
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

	public currentUserSession getCurrenUserSession() {
		return currenUserSession;
	}

	public void setCurrenUserSession(currentUserSession currenUserSession) {
		this.currenUserSession = currenUserSession;
	}

	public Travels getTravels() {
		return travels;
	}

	public void setTravels(Travels travels) {
		this.travels = travels;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busType=" + busType + ", busNumber=" + busNumber + ", capacity=" + capacity
				+ ", route=" + route + ", currenUserSession=" + currenUserSession + ", travels=" + travels + "]";
	}

}
