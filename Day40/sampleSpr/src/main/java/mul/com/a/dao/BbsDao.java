package mul.com.a.dao;

import java.util.List;

import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;

public interface BbsDao {

	List<BbsDto> getBbsList(BbsParam param);
	int getAllBbs(BbsParam param);
	
	boolean writeBbs(BbsDto bbs);
	
	BbsDto getBbs(int seq);
	
	void readcount(int seq);
	
	boolean answerUpdate(int seq);
	
	boolean answerInsert(BbsDto bbs);
	
	boolean updateBbs(BbsDto bbs);
}
