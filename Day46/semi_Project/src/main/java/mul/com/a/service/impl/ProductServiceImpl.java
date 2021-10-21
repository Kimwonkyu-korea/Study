package mul.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.a.dao.ProductDao;
import mul.com.a.dto.CartDto;
import mul.com.a.dto.ProductDto;
import mul.com.a.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired(required = true)
	ProductDao dao;
	 
	// 상품 목록
	@Override
	public List<ProductDto> listProduct() {
		
		return dao.listProduct();
	}

	// 상품 상세
	@Override
	public ProductDto detailProduct(int productId) {
		return dao.detailProduct(productId);
	}
	
	// 상품 수정
	@Override
	public void updateProduct(ProductDto dto) {
		
	}

	// 상품 삭제
	@Override
	public void deleteProduct(int productId) {
		
	}
	
}
