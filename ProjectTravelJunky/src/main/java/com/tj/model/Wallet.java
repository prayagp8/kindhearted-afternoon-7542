package com.tj.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId;
	
	private double walletBalance;

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}
	
	
	

	

}
