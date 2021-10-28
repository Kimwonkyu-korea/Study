package mul.com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.com.a.dto.MemberDto;
import mul.com.a.service.MemberService;

@RestController // restful    @Controller + @ResponseBody
public class MemberController {

	@Autowired
	MemberService service;	
	
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public String idcheck(String id) {
		System.out.println("MemberController idcheck");
		System.out.println("id:" + id);
		
		boolean b = service.idcheck(id);
		if(b) { // 있다
			return "YES";
		}else { // 없다
			return "NO";
		}
	}
	

	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public String addMember(MemberDto dto) {
		System.out.println("MemberController addMember()");
		System.out.println(dto.toString());
		
		boolean b = service.addMember(dto);
		if(b == true) {	// 추가	
			return "OK";
		}
		return "NG";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public MemberDto login(String id, String pwd) {	// 매개변수 dto도 가능
		System.out.println("MemberController login");
		
		MemberDto dto = service.login(new MemberDto(id, pwd, "", "", 0));
		return dto;
	}
}





