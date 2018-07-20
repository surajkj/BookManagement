package com.bookmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanagement.dao.UserDao;
import com.bookmanagement.model.User;
import com.bookmanagement.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<UserVo> getUsers(){
		List<User> users =  userDao.getUsers();
		List<UserVo> userList = new ArrayList<UserVo>();
		if(users != null) {
			for (User user : users) {
				UserVo userVo = new UserVo();
				userVo.setName(user.getName());
				userVo.setDob(user.getDob());
				
				userList.add(userVo);
			}
		}
		
		return userList;
	}

	@Override
	public UserVo getUserById(Long userId) {
		User user = userDao.getUserById(userId);
		
		if(user!=null) {
			UserVo uservo = new UserVo();
			uservo.setName(user.getName());
			uservo.setDob(user.getDob());
			return uservo;
		}
		return null;
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
