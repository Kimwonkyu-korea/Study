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
	BbsDao dao;

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
	
	
}








