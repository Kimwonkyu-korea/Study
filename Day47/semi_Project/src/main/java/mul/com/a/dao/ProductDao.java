package mul.com.a.dao;

import java.util.List;

import mul.com.a.dto.CartDto;
import mul.com.a.dto.ProductDto;

public interface ProductDao {
	
	List<ProductDto> listProduct();
	
	ProductDto detailProduct(int productId);
	
	void updateProduct(ProductDto dto);
	
	void deleteProduct(int productId);
	
}
