package mul.com.a.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mul.com.a.dao.CartDao;
import mul.com.a.dto.CartDto;
import mul.com.a.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao dao;

	@Override
	public List<CartDto> cartlist(String user_id) {
		return dao.cartlist(user_id);
	}

	@Override
	public boolean delete(CartDto dto) {
		return dao.delete(dto);
	}

	@Override
	public boolean deleteAll(CartDto dto) {
		return dao.deleteAll(dto);
	}

	@Override
	public List<CartDto> ordercheck(CartDto dto) {
		return dao.ordercheck(dto);
	}

	@Override
	public void insertProduct(CartDto dto) {
		dao.insertProduct(dto);
		
	}
	
	
	

	
}
