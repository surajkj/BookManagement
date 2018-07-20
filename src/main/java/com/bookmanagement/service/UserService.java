package com.bookmanagement.service;

import java.util.List;

import com.bookmanagement.model.User;
import com.bookmanagement.vo.UserVo;

public interface UserService {
	
	public List<UserVo> getUsers();
	
	public UserVo getUserById(Long userId);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(Long userId);

}
