package com.tj.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	private String adminName;
	private String password;
	private String email;
	private String mobile;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Admin(Integer adminId, String adminName, String password, String email, String mobile) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", password=" + password + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}
	

}
