package com.controller;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;
import com.service.ProductFileUpload;

import jakarta.servlet.http.HttpSession;

@Controller
public class EComController{

	@Autowired
	UserDao userDao;

	@Autowired
	ProductFileUpload fileUploadService;

	@GetMapping(value = { "/", "elogin" })
	public String welcome() {
		return "Elogin";
	}

	@PostMapping("/elogin")
	public String eLogin(UserBean userBean, Model model, HttpSession session) {
		System.out.println("32 => " + userBean.getEmail());
		System.out.println("33 => " + userBean.getPassword());

		UserBean dbUser = userDao.authenticate(userBean.getEmail(), userBean.getPassword());
		if (dbUser == null) {
			model.addAttribute("error", "Invalid Credentials");
			return "Elogin";
		} else {

			session.setAttribute("user", dbUser);
			model.addAttribute("firstName", dbUser.getFirstName());
			model.addAttribute("profilePicPath", dbUser.getProfilePicPath());	
			return "EcomHome";
		}
	}

	@GetMapping("/esignup")
	public String signup() {
		return "Esignup";
	}

	@PostMapping("/esignup")
	public String signupPost(UserBean userBean) {

		fileUploadService.uploadUserImage(userBean.getProfilePic(), userBean.getEmail());

		// images//profilepic//rock1@gmail.com//123.png

		userBean.setProfilePicPath(
				"Image//" + userBean.getEmail() + "//" + userBean.getProfilePic().getOriginalFilename());
		// insert
		userDao.insertUser(userBean);
		// image server upload
		// id

		// profilepic/jack@gmai.com/timestamp_aa.jpg

		// profilepic/0522461526122aa.jpg
		// profilepic/0522461527122aa.jpg

		return "Elogin";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//destroy session 
		session.invalidate();
		return "redirect:/elogin";
	}

}