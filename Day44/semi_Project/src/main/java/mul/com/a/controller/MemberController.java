package mul.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mul.com.a.dto.MemberDto;
import mul.com.a.service.MemberService;

@Controller
public class MemberController {

	private static Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService service;
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("MemberController login " + new Date());
		
		return "member/login";	
	}
	
	@RequestMapping(value = "regi.do", method = RequestMethod.GET)
	public String regi() {
		logger.info("MemberController regi " + new Date());
		
		return "member/regi";
	}
	
	@ResponseBody
	@RequestMapping(value = "idcheck.do", method = RequestMethod.POST)
	public String idcheck(String id) {
		logger.info("MemberController idcheck() " + new Date());
		
		boolean b = service.idcheck(id);
		if(b == true) {
			return "NO";
		}else {
			return "YES";
		}
	}
	
	@RequestMapping(value = "regiAf.do", method = RequestMethod.POST)
	public String regiAf(Model model, MemberDto dto) { //  Model : 택배 
		logger.info("MemberController regiAf() " + new Date());
	//	System.out.println(dto.toString());
		
		boolean b = service.addMember(dto);
		String add = "NO";
		if(b) {
			add = "YES";
		}	
		model.addAttribute("add", add); 
		
		return "message";
	}
	
	// 로그인 후
	@RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
	public String loginAf(MemberDto mem, HttpSession session) {	
		logger.info("MemberController loginAf() " + new Date());
		// 리턴값 받아옴
		MemberDto dto = service.login(mem);
		
		// id 값이 null이 아니고 빈 문자가아닐 때
		if(dto != null && dto.getUser_id().equals("") == false) {
			// session에 저장 : 상자  - > 웹 서버 저장 공간
			session.setAttribute("login", dto);
			// 시간 저장도 가능
			
			// bbslist.do로 이동,		Controller -> Controller
			return "redirect:/product.do";	// controller로 이동 시 redirect
			
			// return "forward:bbslist.do"; -> 짐을 갖고 이동 시
			
		}else {
			return "redirect:/login.do";
		}
	}
}









