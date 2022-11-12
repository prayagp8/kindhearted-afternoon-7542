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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@Pattern(regexp = "^[A-Z][a-z]",message = "Name cannot start with number of symbol")
	private String adminName;
	
	@Size(min = 3, max = 20, message = "Password length should be minimun 3")
	private String password;
	
	@Email
	private String email;
	
	@Pattern(regexp="(^$|[0-9]{10})",message = "Enter valid mobile length of length 10")
	private String mobile;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Report> reports = new ArrayList<>();

	

	public Admin(Integer adminId, String adminName, String password, String email, String mobile) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	public Admin() {

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


	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	

}
