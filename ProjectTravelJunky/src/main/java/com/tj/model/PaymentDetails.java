package com.tj.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.validation.constraints.NotNull;

@Entity
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	private LocalDateTime time;
	
	@NotNull
	private String cardNo;
	public PaymentDetails(Integer paymentId, LocalDateTime time, String cardNo) {
		super();
		this.paymentId = paymentId;
		this.time = time;
		this.cardNo = cardNo;
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

	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", time=" + time + ", cardNo=" + cardNo + "]";
	}

}
