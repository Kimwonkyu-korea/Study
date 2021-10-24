package mul.com.a.controller;

import java.io.IOException; 
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
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
	
	@ResponseBody
	@RequestMapping(value = "json.do", method = RequestMethod.GET)
	public void json(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		logger.info("MemberController json() " + new Date());
		
		List<MemberDto> member = service.getallmember();
		
		JSONArray memberlist = new JSONArray();
		
		for (int i = 0; i < member.size(); i++) {
			MemberDto dto = member.get(i);
			
			JSONObject obj = new JSONObject();
			
			obj.put("id", dto.getId().toString());
			obj.put("pwd", dto.getPwd().toString());
			obj.put("name", dto.getName().toString());
			obj.put("email", dto.getEmail().toString());
			obj.put("auth", dto.getAuth().toString());
			
			memberlist.put(obj);
		}
		
		System.out.println(memberlist.toString());
		
		resp.getWriter().print(memberlist);
	}
	
}
