package mul.com.a.service;

import java.util.List;

import mul.com.a.dto.CartDto;

public interface CartService {
	
	
	public List<CartDto> getCartList(String user_id);
}
