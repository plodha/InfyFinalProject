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
@GenericGenerator(name="purchaseGenerator", strategy="sequence",
parameters = {@Parameter(name="sequence", value=" purchase_txn_sequence_pk")})
@Table(name = "Computer_Purchase_Details")
public class ComputerPurchaseEntity {
	
	@Temporal(TemporalType.DATE)
	private Calendar purchaseDate;
	private String computerId;
	private String userId;
	private Double totalCost;
	@Id
	@GeneratedValue(generator="purchaseGenerator")
	private String purchaseId;
	private String mobileNo;
	
	public Calendar getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Calendar purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getComputerId() {
		return computerId;
	}
	public void setComputerId(String computerId) {
		this.computerId = computerId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}
