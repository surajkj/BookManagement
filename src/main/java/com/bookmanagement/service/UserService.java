package com.bookmanagement.service;

import java.util.List;

import com.bookmanagement.vo.ChangePasswordVo;
import com.bookmanagement.vo.UserFormVo;
import com.bookmanagement.vo.UserVo;

public interface UserService {
	
	public List<UserVo> getUsers();
	
	public UserVo getUserById(Long userId);
	
	public Long addUser(UserFormVo user);
	
	public void updateUser(UserFormVo user);
	
	public void deleteUser(Long userId);
	
	public Boolean validatePassword(UserFormVo user);
	
	public Boolean updatePassword(ChangePasswordVo changePasswordVo);

}
