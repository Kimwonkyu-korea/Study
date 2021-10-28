package mul.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.com.a.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {
	
	int idcheck(String id);	// .xml에 resultType
	int addMember(MemberDto dto);
	MemberDto login(MemberDto dto);
}
