package mul.com.a.service;

import java.util.List;

import mul.com.a.dto.AdminDto;

public interface AdminService {
	
	public List<AdminDto> memberlist(String user_id);
}
