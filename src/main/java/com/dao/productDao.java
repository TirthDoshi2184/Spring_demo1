package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.EProductBean;

@Repository
public class productDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addProduct(EProductBean product) {
		stmt.update("insert into products(productId,productName,category,qty,price) values (?,?,?,?,?)",product.getProductId(),product.getProductName(),product.getCategory(),product.getQty(),product.getPrice());
	}
	
	public List<EProductBean> getallproduct(){
		
		List<EProductBean> list =stmt.query("select * from products", new BeanPropertyRowMapper<EProductBean>(EProductBean.class));
		return list;
	}

	public void deleteproductwithId(Integer productId) {
		stmt.update("delete from products where productId = ?",productId);
	}
	
	public void deleteproductwithName(String productName) {
		stmt.update("delete from products where productName = ?",productName);
	}
	
public EProductBean getSingleProductName(Integer productId) {
		
		EProductBean pbean =  stmt.queryForObject("select * from products where productId = ?",
				new BeanPropertyRowMapper<>(EProductBean.class),new Object[] {productId});
		return pbean;
	}


public EProductBean getProductById(Integer productId) {

	EProductBean bean = stmt.queryForObject("select * from products where productId = ? ",
			new BeanPropertyRowMapper<>(EProductBean.class), new Object[] { productId }); // name color
	return bean;
}

}

