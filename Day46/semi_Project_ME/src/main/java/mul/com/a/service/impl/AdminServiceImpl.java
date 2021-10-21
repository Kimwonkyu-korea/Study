package mul.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.a.dao.AdminDao;
import mul.com.a.dto.AdminDto;
import mul.com.a.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDao dao;

	@Override
	public List<AdminDto> memberlist(String user_id) {
		return dao.memberlist(user_id);
	}
	
}
