package mul.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.a.dao.BbsDao;
import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired
	SqlSession session;
	
	String ns = "Bbs.";

	@Override
	public List<BbsDto> getBbsList(BbsParam param) {		
		return session.selectList(ns + "bbslist", param);
	}
	@Override
	public int getAllBbs(BbsParam param) {		
		return session.selectOne(ns + "allbbs", param);
	}
	
	@Override
	public boolean writeBbs(BbsDto bbs) {
		int n = session.insert(ns + "writeBbs", bbs);
		return n>0?true:false;
	}
	
	
	
	
}








