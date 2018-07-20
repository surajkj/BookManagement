package com.bookmanagement.dao;

import java.util.List;

import com.bookmanagement.model.User;

public interface UserDao {
	
	public List<User> getUsers();
	
	public User getUserById(Long userId);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(Long userId);

}
