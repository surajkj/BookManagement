package com.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanagement.service.UserService;
import com.bookmanagement.vo.ChangePasswordVo;
import com.bookmanagement.vo.UserFormVo;
import com.bookmanagement.vo.UserVo;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public List<UserVo> getAllUser() {
		return userService.getUsers();
	}
	
	@GetMapping("/{userId}")
	public UserVo getUserById(@PathVariable("userId") Long userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping
	public ResponseEntity<UserFormVo> addUser(@RequestBody UserFormVo user) {
		Long id=userService.addUser(user);
		user.setUserId(id);
		return new ResponseEntity<UserFormVo>(user,HttpStatus.OK);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<Boolean> validatePassword(@RequestBody UserFormVo user){
		Boolean validateStatus=false;
		validateStatus = userService.validatePassword(user);
		return new ResponseEntity<Boolean>(validateStatus,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<UserFormVo> updateUser(@RequestBody UserFormVo user) {
		userService.updateUser(user);
		return new ResponseEntity<UserFormVo>(user,HttpStatus.OK);
	}
	
	@PutMapping("/changepassword")
	public ResponseEntity<Boolean> changePassword(@RequestBody ChangePasswordVo changePasswordVo){
		Boolean passwordUpdated=false;
		passwordUpdated = userService.updatePassword(changePasswordVo);
		return new ResponseEntity<Boolean>(passwordUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Long> deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<Long>(userId,HttpStatus.OK);
	}

}
