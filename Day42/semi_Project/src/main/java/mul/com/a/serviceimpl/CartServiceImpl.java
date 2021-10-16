package mul.com.a.serviceimpl;


import java.util.List;

import org.springframework.stereotype.Service;
import mul.com.a.dao.CartDao;
import mul.com.a.dto.CartDto;
import mul.com.a.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	CartDao dao;

	@Override
	public List<CartDto> cartlist(String user_id) {
		return dao.cartlist(user_id);
	}
	
}
