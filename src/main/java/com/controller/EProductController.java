package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EProductBean;
import com.dao.productDao;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EProductController {
	
	@Autowired
	productDao product;
	
	@GetMapping("/product")
	public String product() {
		return "Addproduct";
	}
	
	@PostMapping("/product")
	public String productadd(EProductBean productBean) {
		
		product.addProduct(productBean);
		return "redirect:/products";
		
	}

	@GetMapping("/products")
	public String listproduct(Model model) {
		List<EProductBean> products = product.getallproduct();
		
		model.addAttribute("products",products);
		return "NewListproduct";
	}
	
	@GetMapping("/deleteproduct")
	public String deleteproduct(@RequestParam("productId") Integer productId) {

		System.out.println("delete prouduct() => "+productId);
		
		return "redirect:/products";
	}
	
}
