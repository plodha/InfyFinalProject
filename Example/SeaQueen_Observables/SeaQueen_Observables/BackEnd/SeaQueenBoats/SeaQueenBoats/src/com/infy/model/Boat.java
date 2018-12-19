package com.infy.model;

import java.util.Calendar;

public class Boat {
	
	private String boatId;
	private String boatType ;
	private String location;
	private String description;
	private Double basePrice;
	private Integer allowedDays;
	private Float discount;
	private Calendar bookingStart;
	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Calendar getBookingStart() {
		return bookingStart;
	}

	public void setBookingStart(Calendar bookingStart) {
		this.bookingStart = bookingStart;
	}

	private String message;
	

	public String getBoatId() {
		return boatId;
	}

	public void setBoatId(String boatId) {
		this.boatId = boatId;
	}

	public String getBoatType() {
		return boatType;
	}

	public void setBoatType(String boatType) {
		this.boatType = boatType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public Integer getAllowedDays() {
		return allowedDays;
	}

	public void setAllowedDays(Integer allowedDays) {
		this.allowedDays = allowedDays;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
