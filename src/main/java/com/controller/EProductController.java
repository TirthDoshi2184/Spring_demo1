package com.controller;

import java.io.File;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.EProductBean;
import com.dao.productDao;
import org.springframework.web.bind.annotation.RequestParam;
import com.service.ProductFileUpload;

import ch.qos.logback.core.util.FileUtil;


@Controller
public class EProductController {
	
	@Autowired
	productDao product;
	
	@Autowired
	ProductFileUpload pupload;
 
	
	@PostMapping("/saveproduct")
	public String addProduct(EProductBean productBean, @RequestParam("masterImage") MultipartFile masterImage) {
		System.out.println("MasterImageName :-" + productBean.getMasterImage());	
		
		pupload.productfileupload(masterImage);
		product.addProduct(productBean);
		
		return "redirect:/products";
	}
	

	
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
		
		product.deleteproductwithId(productId);
		return "redirect:/products";
	}
	
	@GetMapping("/Deleteproduct")
	public String DeleteProduct() {
		return "Deleteproduct";
	}
	
	@PostMapping("/Deleteproductwithname")
	public String productdelete(EProductBean productBean) {
		
		product.deleteproductwithName(productBean.getProductName());
		return "redirect:/products";
		
	}

	@GetMapping("/viewproduct")
	public String viewProduct(@RequestParam("productId") Integer productId, Model model) {

		// id->details->table : products
		// select * from products where productId = ?
		EProductBean productBean = product.getProductById(productId);
		model.addAttribute("product", productBean);

		return "ViewProduct";
	
	}
	
	
}
