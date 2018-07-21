package com.bookmanagement.vo;

import java.util.Date;

public class UserVo {
	
	private Long userId;
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
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", name=" + name + ", dob=" + dob + "]";
	}
}
