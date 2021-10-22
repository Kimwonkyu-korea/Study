package mul.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.a.dao.AdminDao;
import mul.com.a.dto.AdminDto;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	SqlSession session;
	
	String ns = "Admin.";

	@Override
	public List<AdminDto> memberlist(String user_id) {
		return  session.selectList(ns + "memberlist", user_id);
		
	}
	
}
