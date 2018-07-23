package com.bookmanagement.vo;

public class UserFormVo {
	
	private Long userId;
	private String userName;
	private String password;
	private String emailId;
	private String name;
	private String dob;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "UserFormVo [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", name=" + name
				+ ", dob=" + dob + "]";
	}
	
	
}
