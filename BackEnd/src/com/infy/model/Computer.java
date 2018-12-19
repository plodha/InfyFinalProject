package com.infy.model;

public class Computer {
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
	
	private String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
