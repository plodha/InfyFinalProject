package com.infy.entity;

@Entity
@GenericGenerator(name="usersGenerator", strategy="sequence",
parameters = {@Parameters(name="sequence", value="users_sequence_pk")})
@Table(name = "PCUser")
public class UserEntity {
	private String userName;
	private String password;
	private String email;
	@Id
	@GeneratedValue(generator="usersGenerator")
	private String userId;
	private String mobileNo;
	private int creditScore;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}	
}
