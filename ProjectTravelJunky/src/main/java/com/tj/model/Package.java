package com.tj.model;

public class Package {
	private Integer packageId;
	private String packageName;
	private String packageDescription;
	private String packageType;
	private Double packageCost;
	private PaymentDetails payment;
	
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
		this.payment = payment;
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

	public PaymentDetails getPayment() {
		return payment;
	}

	public void setPayment(PaymentDetails payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", packageType=" + packageType + ", packageCost=" + packageCost + ", payment="
				+ payment + "]";
	}
	
	
}
