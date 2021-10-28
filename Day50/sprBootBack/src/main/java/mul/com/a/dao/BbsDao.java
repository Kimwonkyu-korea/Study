package mul.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;

@Mapper
@Repository
public interface BbsDao {
	
	
	List<BbsDto> getbbslist(BbsParam param);
	int getbbscount(BbsParam param);
}
