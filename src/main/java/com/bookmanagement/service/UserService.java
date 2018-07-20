package com.bookmanagement.service;

import java.util.List;

import com.bookmanagement.model.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public User getUserById(Long userId);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(Long userId);

}
