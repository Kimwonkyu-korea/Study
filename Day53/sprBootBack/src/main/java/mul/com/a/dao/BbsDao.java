package mul.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;

@Mapper
@Repository
public interface BbsDao {
	
	// 로그인 후 게시판 리스트형태
	List<BbsDto> getbbslist(BbsParam param);
	// 글의 총수
	int getbbscount(BbsParam param);
	// 글쓰기
	int writeBbs(BbsDto bbs);
	// 상세글보기
	BbsDto getBbs(int seq);
	// 답글
	boolean answerupdate(BbsDto dto);
	
	boolean answerinsert(BbsDto dto);
	
	// 글 수정 
	int updateBbs(BbsDto bbs);
	
	// 글 삭제
	boolean deleteBbs(int seq);
	
}
