package com.controller.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.EProductBean;
import com.dao.productDao;

@Controller
public class UserProductController {

	@Autowired
	productDao productDao;

	@GetMapping("/userproducts")
	public String listProducts(Model model) {
		List<EProductBean> products = productDao.getallproduct();// return type

		model.addAttribute("products", products);

		return "EcomUserproduct";
	}
}