package com.tj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@Pattern(regexp = "^[A-Z][a-z]",message = "Name cannot start with number of symbol")
	private String name;
	
	@Size(min = 3, max = 20, message = "Password length should be minimun 3")
	private String costumerpassword;
	private String address;
	
	@Pattern(regexp="(^$|[0-9]{10})",message = "Enter valid mobile length of length 10")
	private String mobileNo;
	
	@Email
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
