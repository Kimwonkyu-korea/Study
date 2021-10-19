package mul.com.a.dao.impl;

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
	public boolean product(CartDto dto) {
		int n = sqlSession.insert(namespace + "product", dto);
		return n>0?true:false;
	}
	
	
}
