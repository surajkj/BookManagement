package com.bookmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanagement.dao.UserDao;
import com.bookmanagement.model.User;
import com.bookmanagement.utility.ApplicationConstants;
import com.bookmanagement.utility.DateUtility;
import com.bookmanagement.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<UserVo> getUsers(){
		List<User> users =  userDao.getUsers();
		List<UserVo> userList = new ArrayList<UserVo>();
		try {
			if(users != null) {
				for (User user : users) {
					UserVo userVo = new UserVo();
					userVo.setUserId(user.getUserId());
					userVo.setName(user.getName());
					userVo.setDob(DateUtility.setDobFormat(user.getDob()));
					
					userList.add(userVo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public UserVo getUserById(Long userId) {
		User user = userDao.getUserById(userId);
		try {
			if(user!=null) {
				UserVo uservo = new UserVo();
				uservo.setUserId(user.getUserId());
				uservo.setName(user.getName());
				uservo.setDob(DateUtility.setDobFormat(user.getDob()));
				return uservo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void addUser(UserVo uservo) {
		try {
			User user = new User();
			user.setName(uservo.getName());
			user.setDob(DateUtility.stringToDate(uservo.getDob(),ApplicationConstants.DOB_FORMAT ));
			user.setCreatedDate(DateUtility.getCurrentDate());
			user.setIsActive(ApplicationConstants.IS_ACTIVE);
			userDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(UserVo uservo) {
		try {
			User user = new User();
			user.setUserId(uservo.getUserId());
			user.setName(uservo.getName());
			user.setDob(DateUtility.stringToDate(uservo.getDob(),ApplicationConstants.DOB_FORMAT ));
			user.setCreatedDate(DateUtility.getCurrentDate());
//			user.setIsActive(ApplicationConstants.IS_ACTIVE);
			userDao.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(Long userId) {
		userDao.deleteUser(userId);
	}
	
}
