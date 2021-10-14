package mul.com.a.service;

import java.util.List;

import mul.com.a.dto.PdsDto;

public interface PdsService {

	public List<PdsDto> getPdsList();
	
	public boolean uploadPds(PdsDto dto);
	
	public PdsDto getPds(int seq);
}
