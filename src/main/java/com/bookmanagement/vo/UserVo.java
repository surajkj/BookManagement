package com.bookmanagement.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserVo {
	
	private Long userId;
	private String userName;
	private String emailId;
	private String name;
	private String dob;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", name=" + name
				+ ", dob=" + dob + "]";
	}
	
}
