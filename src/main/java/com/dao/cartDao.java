package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EcomCartBean;

@Repository
public class cartDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addTocart(EcomCartBean cartBean) {
		stmt.update("insert into cart(productId,userId) value (?,?)",cartBean.getProductId(),cartBean.getUserId()); 
	}
}
