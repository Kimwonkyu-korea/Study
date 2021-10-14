package mul.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.a.dao.BbsDao;
import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;
import mul.com.a.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService {
	
	@Autowired
	BbsDao dao ; 	// new BbsDaoImpl(); 자동완성

	@Override
	public List<BbsDto> getBbsList(BbsParam param) {		
		return dao.getBbsList(param);
	}

	@Override
	public int getAllBbs(BbsParam param) {		
		return dao.getAllBbs(param);
	}

	@Override
	public boolean writeBbs(BbsDto bbs) {		
		return dao.writeBbs(bbs);
	}
	
	

	@Override
	public void readcount(int seq) {
		dao.readcount(seq);
	}

	@Override
	public BbsDto getBbs(int seq) {
		dao.readcount(seq);
		return dao.getBbs(seq);
	}
	

	@Override
	public boolean answerUpdate(int seq) {
		return dao.answerUpdate(seq);
	}

	@Override
	public boolean answerInsert(BbsDto bbs) {
		return dao.answerInsert(bbs);
	}

	@Override
	public boolean updateBbs(BbsDto bbs) {
		return dao.updateBbs(bbs);
	}

	@Override
	public boolean deleteBbs(int seq) {
		return dao.deleteBbs(seq);
	}	
	
}
