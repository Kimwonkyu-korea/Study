package mul.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.a.dao.ProductDao;
import mul.com.a.dto.CartDto;
import mul.com.a.dto.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SqlSession sqlSession; // IOC, DI
	
	String namespace = "Product.";
	
	@Override
	public List<ProductDto> listProduct() {
		return sqlSession.selectList(namespace + "listProduct");
	}

	@Override
	public ProductDto detailProduct(int productId) {
		return sqlSession.selectOne(namespace + "detailProduct", productId);
	}

	@Override
	public void updateProduct(ProductDto dto) {
		
	}

	@Override
	public void deleteProduct(int productId) {
		
	}
	
}
