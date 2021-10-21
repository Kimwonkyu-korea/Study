package mul.com.a.dao;

import mul.com.a.dto.CartDto;
import mul.com.a.dto.ProductDto;

public interface ProductDao {

	boolean product(CartDto dto);
	
}
