package com.tj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class TicketDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;
	
	@NotNull
	private String status;
	
	@OneToOne
	private Route route;
	
	@OneToOne
	private Package packages;
	
	public TicketDetails() {
		// TODO Auto-generated constructor stub
	}

	public TicketDetails(Integer ticketId, String status, Route route, Package packages) {
		super();
		this.ticketId = ticketId;
		this.status = status;
		this.route = route;
		this.packages = packages;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Package getPackages() {
		return packages;
	}

	public void setPackages(Package packages) {
		this.packages = packages;
	}
}
