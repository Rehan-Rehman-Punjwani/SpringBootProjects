package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.service.UserService;


@Controller
public class LoginController {

	@Autowired
	UserService userService;

	
	@RequestMapping("/")
	public String Welcome(HttpServletRequest req) {
		req.setAttribute("mode", "MODE_HOME");
		return "welcome";
	}
	@RequestMapping("/register")
	public String register(HttpServletRequest req) {
		req.setAttribute("mode", "MODE_REG");
		return "welcome";
	}
	
	@PostMapping("/save-user")
	public String register(@ModelAttribute User user, BindingResult bindingResult,HttpServletRequest req) {
	
		userService.saveUser(user);
		req.setAttribute("mode", "MODE_HOME");
		return "welcome";
	}

	@GetMapping("/show-users")
	public String showuser(HttpServletRequest req) {
		req.setAttribute("users", userService.showUser());
		req.setAttribute("mode", "MODE_ALL");
		return "welcome";
	}
	
	@RequestMapping("/delete-user")
	public String delete(@RequestParam("id") int id, HttpServletRequest req)
	{
	
		userService.deleteUser(id);
		req.setAttribute("users", userService.showUser());
		req.setAttribute("mode","MODE_ALL");
		return "welcome";
	}
	
	@RequestMapping("/edit-user")
	public String update(HttpServletRequest req, @RequestParam int id) {
		req.setAttribute("user", userService.UpdateUser(id));
		req.setAttribute("mode", "MODE_UP");
		return "welcome";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest req) {
		req.setAttribute("mode", "MODE_LOGIN");
		return "welcome";
	}
//	@PostMapping("/login-user")
//	public String checkLogin(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest req)  {
//		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())) {
//			return "home";
//		}
//		else {
//			req.setAttribute("error", "invalid username or password");
//			req.setAttribute("mode", "MODE_LOGIN");
//			return "welcome";
//		}
//		
//	}
	@PostMapping("/login-user")
		public String checkLogin(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest req)  {
			if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
				return "home";
			}
			else {
				req.setAttribute("error", "invalid username or password");
				req.setAttribute("mode", "MODE_LOGIN");
				return "welcome";
			}	
	}	
	
}
