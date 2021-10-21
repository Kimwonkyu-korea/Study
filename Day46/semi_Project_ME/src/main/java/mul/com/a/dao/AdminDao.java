package mul.com.a.dao;

import java.util.List;

import mul.com.a.dto.AdminDto;


public interface AdminDao {
	
	List<AdminDto> memberlist(String user_id);
}
