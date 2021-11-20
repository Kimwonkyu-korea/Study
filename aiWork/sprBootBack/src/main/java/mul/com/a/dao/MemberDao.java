package mul.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.com.a.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {
	// 리턴값은 .xml에 resultType, 매개변수는 .xml에 para..값
	int idcheck(String id);		// boolean으로 받음
	int addMember(MemberDto dto);	// boolean
	MemberDto login(MemberDto dto);
}
