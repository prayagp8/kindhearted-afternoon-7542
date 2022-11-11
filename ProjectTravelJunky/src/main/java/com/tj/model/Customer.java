package com.tj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String name;
	private String costumerpassword;
	private String address;
	private String mobileNo;
	private String email;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Feedback> feedbackList = new ArrayList<>(); 
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	
	

	public Customer(Integer customerId, String name, String costumerpassword, String address, String mobileNo,
			String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.costumerpassword = costumerpassword;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
	}




	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCostumerpassword() {
		return costumerpassword;
	}

	public void setCostumerpassword(String costumerpassword) {
		this.costumerpassword = costumerpassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", costumerpassword=" + costumerpassword
				+ ", address=" + address + ", mobileNo=" + mobileNo + ", email=" + email + "]";
	}

	
	
	
	

	
	
}
