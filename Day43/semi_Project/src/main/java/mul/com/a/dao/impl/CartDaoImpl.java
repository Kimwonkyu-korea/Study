package mul.com.a.dao.impl;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.a.dao.CartDao;
import mul.com.a.dto.CartDto;

@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	SqlSession session;
	
	String ns = "cart.";
	
	@Override
	public List<CartDto> getCartList(String user_id) {
		return session.selectList(ns + "cartlist", user_id);
	}

	/*
	

	
	
	
	 * @Override public void delete(int cart_id) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public void deleteAll(String user_id) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 */
	
}
