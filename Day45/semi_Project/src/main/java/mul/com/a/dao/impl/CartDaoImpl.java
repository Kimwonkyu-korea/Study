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
	
	String ns = "Cart.";

	@Override
	public List<CartDto> cartlist(String user_id) {
		return session.selectList(ns + "cartlist", user_id);
	}
	
	 @Override
	 public boolean delete(CartDto dto) { 
		 int n = session.delete(ns + "delete", dto);
		 return n>0?true:false;
	 }

	@Override
	public boolean deleteAll(CartDto dto) {
		int n = session.delete(ns + "deleteAll", dto);
		return n>0?true:false;
	}

	@Override
	public List<CartDto> orderlist(String user_id) {
		return session.selectList(ns + "orderlist", user_id);
	}

	
	
	
}
