package mul.com.a.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.a.db.MemberDao;
import mul.com.a.dto.MemberDto;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao dao;

	@Override
	public List<MemberDto> getallmember() {
		return dao.getallmember();
	}
}
