package mul.com.a.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mul.com.a.dto.AdminDto;
import mul.com.a.service.AdminService;

@Controller
public class AdminController {

	private static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminService service;
	
	@RequestMapping(value = "memberlist.do", method = RequestMethod.GET)
	public String memberlist(String user_id, Model model) {
		logger.info("AdminController memberlist() " + new Date());
	
		List<AdminDto> list = service.memberlist(user_id);
		
		model.addAttribute("memberlist", list);
		
		return "admin/memberlist";
	}
}
