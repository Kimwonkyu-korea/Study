package mul.com.a.service;

import java.util.List;

import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;

public interface BbsService {

	List<BbsDto> getBbsList(BbsParam param);
	int getAllBbs(BbsParam param);
	
	boolean writeBbs(BbsDto bbs);
	
	void readcount(int seq);
	
	BbsDto getBbs(int seq);
	
	boolean answerUpdate(int seq);
	
	boolean answerInsert(BbsDto bbs);
	
	boolean updateBbs(BbsDto bbs); 
	
	boolean deleteBbs(int seq);
}
