package com.tj.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;
	
	@NotNull
	private String routeFrom;
	
	@NotNull
	private String routeTo;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private LocalDate dateOfJourney;
	private String pickupPoint;
	private Double fare;

	
	@OneToOne(cascade = CascadeType.ALL)
	private TicketDetails ticketDetails;


	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;


	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private currentUserSession currenUserSession;




	public Route() {

	}
	
	

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}



	public TicketDetails getTicketDetails() {
		return ticketDetails;
	}



	public void setTicketDetails(TicketDetails ticketDetails) {
		this.ticketDetails = ticketDetails;
	}



	public Bus getBus() {
		return bus;
	}



	public void setBus(Bus bus) {
		this.bus = bus;
	}



	public currentUserSession getCurrenUserSession() {
		return currenUserSession;
	}



	public void setCurrenUserSession(currentUserSession currenUserSession) {
		this.currenUserSession = currenUserSession;
	}



	public Route(Integer routeId, String routeFrom, String routeTo, LocalDateTime departureTime,
			LocalDateTime arrivalTime, LocalDate dateOfJourney, String pickupPoint, Double fare,
			TicketDetails ticketDetails, Bus bus, currentUserSession currenUserSession) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.dateOfJourney = dateOfJourney;
		this.pickupPoint = pickupPoint;
		this.fare = fare;
		this.ticketDetails = ticketDetails;
		this.bus = bus;
		this.currenUserSession = currenUserSession;
	}

	
	
	





	



	

}
