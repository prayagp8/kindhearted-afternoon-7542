package com.tj.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TicketDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;
	
	@NotNull
	private String status;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Route route;
	

	@OneToOne(cascade = CascadeType.ALL)
	private PaymentDetails payment;
	
	public TicketDetails() {
		// TODO Auto-generated constructor stub
	}

	public TicketDetails(String status, Route route, PaymentDetails payment) {
		super();
		this.status = status;
		this.route = route;
		this.payment = payment;
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

	public PaymentDetails getPayment() {
		return payment;
	}

	public void setPayment(PaymentDetails payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "TicketDetails [ticketId=" + ticketId + ", status=" + status + ", route=" + route + ", payment="
				+ payment + "]";
	}


	
	
	
	

	
	
}
