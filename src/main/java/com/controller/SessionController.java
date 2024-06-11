package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.AdditionBean;
import com.bean.UserData;

@Controller
public class SessionController {

	
	@GetMapping("/login")
	public String login(){
		return "Login";
	}
	
	@GetMapping("/signup")
	public String signup(){
		return "Signup";
	}
	
	@GetMapping("/fp")
	public String forgetPassword(){
		return "ForgetPassword";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(UserData userdata, Model model) {
		System.out.println("FirstName :-" + userdata.getFirstName());
		System.out.println("Email :-" + userdata.getEmail());
		System.out.println("Password :-" + userdata.getPassword());
		
		model.addAttribute("user",userdata);
		
		return "Home";
	}
	
	@GetMapping("/add")
	public String addition() {
		return "Addition";
	}
	
	@PostMapping("/addition")
	public String Add(AdditionBean addition,Model model) {
		model.addAttribute("addition",addition);
		return "AdditionShow";
	}
	
}