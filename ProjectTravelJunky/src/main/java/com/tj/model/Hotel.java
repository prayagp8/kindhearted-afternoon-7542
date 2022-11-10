package com.tj.model;

public class Hotel {

	private Integer hotelId;
	private String hotelName;
	private String hotelType;
	private String hotelDescription;
	private String address;
	private Double rent;
	private String status;
	
	public Hotel() {
		// TODO Auto-generated constructor stub
	}

	public Hotel(Integer hotelId, String hotelName, String hotelType, String hotelDescription, String address,
			Double rent, String status) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.hotelDescription = hotelDescription;
		this.address = address;
		this.rent = rent;
		this.status = status;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelType=" + hotelType
				+ ", hotelDescription=" + hotelDescription + ", address=" + address + ", rent=" + rent + ", status="
				+ status + "]";
	}
	
	
}
