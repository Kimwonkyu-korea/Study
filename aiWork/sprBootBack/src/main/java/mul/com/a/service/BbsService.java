package mul.com.a.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.com.a.dao.BbsDao;
import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;

@Service
@Transactional
public class BbsService {

	@Autowired
	BbsDao dao;
	
	public List<BbsDto> getbbslist(BbsParam param) {
		return dao.getbbslist(param);
		
	}
	
	public int getbbscount(BbsParam param) {
		return dao.getbbscount(param);
	}
	
	public boolean writeBbs(BbsDto bbs) {
		int n = dao.writeBbs(bbs);
		
		return n>0?true:false;		
	}
	
	public void readcount(int seq) {
		dao.readcount(seq);
	}
	
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}
	
	public boolean answerupdate(BbsDto bbs) {
		return dao.answerupdate(bbs);
	}
	
	public boolean answerinsert(BbsDto bbs) {
		return dao.answerinsert(bbs);
	}
	
	public boolean updateBbs(BbsDto dto) {
		return dao.updateBbs(dto);
	}
	
	public boolean deleteBbs(int seq) {
		return dao.deleteBbs(seq);
	}

}
