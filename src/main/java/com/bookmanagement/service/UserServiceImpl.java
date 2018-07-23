package com.bookmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanagement.dao.UserDao;
import com.bookmanagement.model.User;
import com.bookmanagement.utility.ApplicationConstants;
import com.bookmanagement.utility.DateUtility;
import com.bookmanagement.vo.ChangePasswordVo;
import com.bookmanagement.vo.UserFormVo;
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
					userVo.setUserName(user.getUserName());
					userVo.setEmailId(user.getEmail_id());
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
				UserVo userVo = new UserVo();
				userVo.setUserId(user.getUserId());
				userVo.setName(user.getName());
				userVo.setUserName(user.getUserName());
				userVo.setEmailId(user.getEmail_id());
				userVo.setDob(DateUtility.setDobFormat(user.getDob()));
				return userVo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Long addUser(UserFormVo uservo) {
		Long id=null;
		try {
			User user = new User();
			user.setName(uservo.getName());
			user.setUserName(uservo.getUserName());
			user.setPassword(uservo.getPassword());
			user.setEmail_id(uservo.getEmailId());
			user.setDob(DateUtility.stringToDate(uservo.getDob(),ApplicationConstants.DOB_FORMAT ));
			user.setCreatedDate(DateUtility.getCurrentDate());
			user.setIsActive(ApplicationConstants.IS_ACTIVE);
			id=userDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public void updateUser(UserFormVo uservo) {
		System.out.println("Updatating user service");
		try {
			User user = userDao.getUserById(uservo.getUserId());
			if(user!=null) {
				user.setUserId(uservo.getUserId());
				user.setName(uservo.getName());
				user.setUserName(uservo.getUserName());
				user.setEmail_id(uservo.getEmailId());
				user.setDob(DateUtility.stringToDate(uservo.getDob(),ApplicationConstants.DOB_FORMAT ));
				user.setCreatedDate(DateUtility.getCurrentDate());
//				user.setIsActive(ApplicationConstants.IS_ACTIVE);
				userDao.updateUser(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(Long userId) {
		userDao.deleteUser(userId);
	}
	
	@Override
	public Boolean validatePassword(UserFormVo userFormVo) {
		Boolean validationStatus=false;
		User user = userDao.getUserByUserName(userFormVo.getUserName());
		if(user!=null && userFormVo.getPassword().equals(user.getPassword())) {
			return true;
		}
		return validationStatus;
	}
	
	@Override
	public Boolean updatePassword(ChangePasswordVo changePasswordVo) {
		Boolean passwordUpdated=false;
		
		User user = userDao.getUserByUserName(changePasswordVo.getUserName());
		
		if(user != null && changePasswordVo.getOldPassword().equals(user.getPassword())) {
			user.setPassword(changePasswordVo.getNewPassword());
			userDao.updateUser(user);
			return true;
		}
		
		return passwordUpdated;
	}
	
}
