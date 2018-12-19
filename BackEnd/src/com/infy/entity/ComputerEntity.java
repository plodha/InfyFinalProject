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
@GenericGenerator(name="computerGenerator", strategy="sequence",
parameters = {@Parameter(name="sequence", value="computer_sequence_pk")})
@Table(name = "PC_Details")
public class ComputerEntity {
	@Id
	@GeneratedValue(generator="computerGenerator")
	private String computerId;
	private String computerType;
	private Double computerPrice;
	
	public String getComputerId() {
		return computerId;
	}
	public void setComputerId(String computerId) {
		this.computerId = computerId;
	}
	public String getComputerType() {
		return computerType;
	}
	public void setComputerType(String computerType) {
		this.computerType = computerType;
	}
	public Double getComputerPrice() {
		return computerPrice;
	}
	public void setComputerPrice(Double computerPrice) {
		this.computerPrice = computerPrice;
	}
}
