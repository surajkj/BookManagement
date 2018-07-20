package com.bookmanagement.vo;

import java.util.Date;

public class UserVo {
	
	public String name;
	public Date dob;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "UserVo [name=" + name + ", dob=" + dob + "]";
	}
	
}
