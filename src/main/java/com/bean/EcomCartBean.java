package com.bean;

import org.springframework.stereotype.Repository;

public class EcomCartBean {

	public Integer getCartId() {
		return CartId;
	}
	public void setCartId(Integer cartId) {
		CartId = cartId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	private Integer CartId;
	private Integer productId;
	private Integer userId;
	
	
}
