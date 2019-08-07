package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/saveuser")
	public String saveUser(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String username,@RequestParam int age, @RequestParam String password) {
		User usr = new User(firstname, lastname,age, username, password);
		userService.saveUser(usr);
	
		return "User Saved";
	}
	

}
