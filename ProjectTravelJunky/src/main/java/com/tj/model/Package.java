package com.tj.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Package {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer packageId;
	private String packageName;
	private String packageDescription;
	private String packageType;
	private Double packageCost;
	
	
	public Package() {
		// TODO Auto-generated constructor stub
	}

	public Package(Integer packageId, String packageName, String packageDescription, String packageType,
			Double packageCost, PaymentDetails payment) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageType = packageType;
		this.packageCost = packageCost;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public Double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(Double packageCost) {
		this.packageCost = packageCost;
	}

	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", packageType=" + packageType + ", packageCost=" + packageCost + "]";
	}

	
	
	
	
}