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
	
	// session : DB 소속
	@Autowired	// session 접근
	SqlSession session;
	
	String ns = "Bbs."; // namespase

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


	@Override
	public BbsDto getBbs(int seq) {		
		return session.selectOne(ns + "getBbs", seq);
	}
	@Override
	public void readcount(int seq) {
		session.update(ns + "readcount", seq);		
	}
	
	@Override
	public boolean answerUpdate(int seq) {
		int n = session.update(ns + "answerUpdate", seq);
		return n>0?true:false;
	}
	
	@Override
	public boolean answerInsert(BbsDto bbs) {
		int n = session.insert(ns + "answerInsert", bbs);
		return n>0?true:false;
	}
	@Override
	public boolean updateBbs(BbsDto bbs) {
		int n = session.update(ns + "updateBbs" , bbs);
		return n>0?true:false;
	}
	@Override
	public boolean deleteBbs(int seq) {
		int n = session.delete(ns + "deleteBbs", seq);
		return n>0?true:false;
	}
	
}
