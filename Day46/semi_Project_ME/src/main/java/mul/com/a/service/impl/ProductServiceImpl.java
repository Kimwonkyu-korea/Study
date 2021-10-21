package mul.com.a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.a.dao.ProductDao;
import mul.com.a.dto.CartDto;
import mul.com.a.dto.ProductDto;
import mul.com.a.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao dao;

	
	 @Override public boolean product(CartDto dto) { 
		 return dao.product(dto);
		 }
	
}
