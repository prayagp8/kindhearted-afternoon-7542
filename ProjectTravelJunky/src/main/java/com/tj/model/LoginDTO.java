package com.tj.model;

public class LoginDTO {

	private String mobileNo;
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
