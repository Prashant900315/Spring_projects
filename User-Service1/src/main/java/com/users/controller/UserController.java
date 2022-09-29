package com.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.entity.User;
import com.users.service.UserService;
import com.users.vo.ResponseTemplate;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/")
	public User saveUer(@RequestBody User user) {
		return  userservice.saveUser(user);
	}
	
	@GetMapping("/{userId}")
	public ResponseTemplate getUserWithDepartment(@PathVariable("userId") Long userId) {
		
		return  userservice.getUserWithDepartment(userId);
	}

}