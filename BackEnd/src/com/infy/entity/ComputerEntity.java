package com.infy.entity;

@Entity
@GenericGenerator(name="computerGenerator", strategy="sequence",
parameters = {@Parameters(name="sequence", value="computer_sequence_pk")})
@Table(name = "PC_Details")
public class ComputerEntity {
	@Id
	@GeneratedValue(name="computerGenerator")
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
