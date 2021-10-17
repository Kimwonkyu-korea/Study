package mul.com.a.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.a.dao.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SqlSession sqlSession; // IOC, DI
	
	String namespace = "Member.";
}
