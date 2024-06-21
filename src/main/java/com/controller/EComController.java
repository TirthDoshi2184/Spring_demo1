package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class EComController {

	@Autowired
	UserDao userDao;
	
	@GetMapping("/esignup")
	public String signup() {
		
		return "Esignup";
	}
	
	@PostMapping("/esignup")
	public String login(UserBean user) {
		
		userDao.insertUser(user);
		return "Elogin";
	}	
}
