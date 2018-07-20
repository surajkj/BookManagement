package com.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanagement.dao.UserDao;
import com.bookmanagement.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> getUsers(){
		return userDao.getUsers();
	}

	@Override
	public User getUserById(Long userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userDao.deleteUser(userId);
	}
	
}
