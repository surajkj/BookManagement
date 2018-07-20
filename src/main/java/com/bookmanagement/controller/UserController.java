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

import com.bookmanagement.model.User;
import com.bookmanagement.service.UserService;
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
	public ResponseEntity<UserVo> addUser(@RequestBody UserVo user) {
		userService.addUser(user);
		return new ResponseEntity<UserVo>(user,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<UserVo> updateUser(@RequestBody UserVo user) {
		userService.updateUser(user);
		return new ResponseEntity<UserVo>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Long> deleteUser(@PathVariable("userId") Long userId) {
		System.out.println("user Id for delete is "+userId);
		userService.deleteUser(userId);
		return new ResponseEntity<Long>(userId,HttpStatus.OK);
	}

}
