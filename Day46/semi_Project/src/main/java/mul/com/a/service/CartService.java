package mul.com.a.service;

import java.util.List;

import mul.com.a.dto.CartDto;

public interface CartService {
	
	
	List<CartDto> cartlist(String user_id);
	
	boolean delete(CartDto dto);
	
	boolean deleteAll(CartDto dto);
	
	List<CartDto> ordercheck(CartDto dto);
	
	void insertProduct(CartDto dto);
	
}
