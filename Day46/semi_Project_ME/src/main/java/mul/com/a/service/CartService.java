package mul.com.a.service;

import java.util.List;

import mul.com.a.dto.CartDto;

public interface CartService {
	
	
	public List<CartDto> cartlist(String user_id);
	
	public boolean delete(CartDto dto);
	
	public boolean deleteAll(CartDto dto);
	
	public List<CartDto> orderlist(String user_id);
	
}
