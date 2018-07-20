package com.bookmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
