package com.tj.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginDTO {

	@Pattern(regexp="(^$|[0-9]{10})",message = "Enter valid mobile length of length 10")
	private String mobileNo;
	
	@Size(min = 3, max = 200, message = "Password length should be minimun 3")
	private String password;
	
	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginDTO(String mobileNo, String password) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [mobileNo=" + mobileNo + ", password=" + password + "]";
	}
	
	
}
