package com.infy.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@GenericGenerator(name="bookingGenerator",strategy="sequence",
parameters={@Parameter(name="sequence",value="booking_txn_sequence_pk")})
@Table(name = "Boat_Booking_Details")
public class BoatBookingEntity {
	
	@Id
	@GeneratedValue(generator="bookingGenerator")
	private Integer txnId;
	private String boatId;
	private String userId;
	
	
	@Temporal(TemporalType.DATE)
	private Calendar startDate;
	
	@Temporal(TemporalType.DATE)
	private Calendar endDate;
	
	private Double totalCost;
	private Long mobileNo;
	
	private Double discount;

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Integer getTxnId() {
		return txnId;
	}

	public void setTxnId(Integer txnId) {
		this.txnId = txnId;
	}

	public String getBoatId() {
		return boatId;
	}

	public void setBoatId(String boatId) {
		this.boatId = boatId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
}
