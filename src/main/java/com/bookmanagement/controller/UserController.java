package com.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanagement.model.User;
import com.bookmanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public String getUser() {
		
		List<User> users =  userService.getUsers();
		if(users != null) {
			for (User user : users) {
				System.out.println("User Id -- "+user.getUserId()+" User Name -- "+user.getName());
			}
		}
		
		return "Hello User";
	}

}
