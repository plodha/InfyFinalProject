package com.infy.entity;


import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;




@Entity
@GenericGenerator(name="boatsGenerator",strategy="sequence",
parameters={@Parameter(name="sequence",value="boats_sequence_pk")})
@Table(name="Boat_Details")
public class BoatEntity {
	
	@Id
	@GeneratedValue(generator="boatsGenerator")
	private Integer boatId;
	private String boatType ;
	private String location;
	private String description;
	private Double basePrice;
	private Integer allowedDays;
	
	private Float discount;
	
	@Temporal(TemporalType.DATE)
	private Calendar bookingStart;
	
	
	public Integer getBoatId() {
		return boatId;
	}
	public void setBoatId(Integer boatId) {
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
	
	
	
	
	
	
	

}
