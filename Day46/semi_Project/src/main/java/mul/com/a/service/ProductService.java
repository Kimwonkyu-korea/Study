package mul.com.a.service;

import java.util.List;

import mul.com.a.dto.CartDto;
import mul.com.a.dto.ProductDto;

public interface ProductService {
	
	// 상품 목록
	List<ProductDto> listProduct();
	
	// 상품 상세
	ProductDto detailProduct(int productId);
	
	// 상품 수정
	void updateProduct(ProductDto dto);
	
	// 상품 삭제
	void deleteProduct(int productId);
}
