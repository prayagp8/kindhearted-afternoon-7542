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

import org.hibernate.validator.constraints.CreditCardNumber;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	private LocalDate time;
	private String name;
	private String address;
	private Double TotalAmount;
	private String Status;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Booking booking;








	public Booking getBooking() {
		return booking;
	}








	public void setBooking(Booking booking) {
		this.booking = booking;
	}








	public PaymentDetails() {
		// TODO Auto-generated constructor stub
	}








	public Integer getPaymentId() {
		return paymentId;
	}








	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
















	public String getName() {
		return name;
	}








	public void setName(String name) {
		this.name = name;
	}








	public String getAddress() {
		return address;
	}








	public void setAddress(String address) {
		this.address = address;
	}








	public Double getTotalAmount() {
		return TotalAmount;
	}








	public void setTotalAmount(Double totalAmount) {
		TotalAmount = totalAmount;
	}








	public String getStatus() {
		return Status;
	}








	public void setStatus(String status) {
		Status = status;
	}








	public PaymentDetails(Integer paymentId, LocalDate time, String name, String address, Double totalAmount,
			String status) {
		super();
		this.paymentId = paymentId;
		this.time = time;
		this.name = name;
		this.address = address;
		TotalAmount = totalAmount;
		Status = status;
	}








	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", time=" + time + ", name=" + name + ", address=" + address
				+ ", TotalAmount=" + TotalAmount + ", Status=" + Status + "]";
	}








	public void setTime(LocalDate now) {
		// TODO Auto-generated method stub
		
	}








	public LocalDate getTime() {
		return time;
	}
	
	


















}
