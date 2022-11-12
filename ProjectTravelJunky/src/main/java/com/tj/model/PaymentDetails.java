package com.tj.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	private LocalDateTime time;
	
	@NotNull
	private String cardNo;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Package packages;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private TicketDetails ticket;
	

	
	public PaymentDetails() {
		// TODO Auto-generated constructor stub
	}



	public LocalDateTime getTime() {
		return time;
	}



	public void setTime(LocalDateTime time) {
		this.time = time;
	}



	public String getCardNo() {
		return cardNo;
	}



	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}



	public Package getPackages() {
		return packages;
	}



	public void setPackages(Package packages) {
		this.packages = packages;
	}



	public TicketDetails getTicket() {
		return ticket;
	}



	public void setTicket(TicketDetails ticket) {
		this.ticket = ticket;
	}



	public Integer getPaymentId() {
		return paymentId;
	}



	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}



	public PaymentDetails(LocalDateTime time, String cardNo, Package packages, TicketDetails ticket) {
		super();
		this.time = time;
		this.cardNo = cardNo;
		this.packages = packages;
		this.ticket = ticket;
	}



	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", time=" + time + ", cardNo=" + cardNo + ", packages="
				+ packages + ", ticket=" + ticket + "]";
	}
	
	



	
	
	



}
