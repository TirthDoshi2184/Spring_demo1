package com.bean;

import org.springframework.web.multipart.MultipartFile;
public class EProductBean {

	private Integer productId;
	private String productName;
	private String category;
	private Integer qty;
	private Float price;
	private String masterImage;
	
	
	
	public String getMasterImage() {
		return masterImage;
	}
	public void setMasterImage(String masterImage) {
		this.masterImage = masterImage;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
}
