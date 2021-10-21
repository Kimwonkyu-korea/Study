package mul.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.a.dao.MemberDao;
import mul.com.a.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession sqlSession; // IOC, DI
	
	String namespace = "Member.";

	@Override
	public List<MemberDto> allMember() {
		List<MemberDto> list = sqlSession.selectList(namespace + "allMember");
		return list;
	}

	@Override
	public boolean idcheck(String id) {	
		int count = sqlSession.selectOne(namespace + "idcheck", id);
		return count>0?true:false;
	}
	
	@Override
	public boolean addMember(MemberDto mem) {
		int n = sqlSession.insert(namespace + "addmember", mem);
		return n>0?true:false;
	}

	@Override
	public MemberDto login(MemberDto mem) {
		
		return sqlSession.selectOne(namespace + "login", mem); 
	}
	
}













