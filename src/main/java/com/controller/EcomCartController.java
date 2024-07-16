package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EcomCartBean;
import com.bean.UserBean;
import com.dao.cartDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class EcomCartController {

	@Autowired
	cartDao cartDao;
	
	@GetMapping("/addtocart")	
	public String addtocart(@RequestParam("productId") Integer productId,HttpSession session) {
	
		UserBean userBean = (UserBean)session.getAttribute("user");
		
		EcomCartBean cartBean = new EcomCartBean();
		
		Integer userId = userBean.getUserID();
		
		cartBean.setProductId(productId);
		cartBean.setUserId(userId);
		
		cartDao.addTocart(cartBean);
		
		return "redirect:/userproducts";
		
	}
}
