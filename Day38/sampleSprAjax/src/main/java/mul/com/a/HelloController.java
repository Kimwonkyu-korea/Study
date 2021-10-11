package mul.com.a;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
		
	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	// 전달 받을 값이 같아야된다.
	public String hello(Model model) {	// hello.jsp로 부터 전달 받는 값, spring 자동으로 바꿔줌 parsing x
		logger.info("HelloController hello() " + new Date());
		
		return "hello";		// <- hello.jsp로 이동
	}
	// doget, dopost 상관없이 가져온다
	@ResponseBody // <- Ajax 설정
	@RequestMapping(value = "idcheck.do", method = { RequestMethod.GET, RequestMethod.POST },
					produces = "application/String; charset=utf-8")
	public String idcheck(String id) { // 리턴 문자열
		logger.info("HelloController idcheck() " + new Date());
		System.out.println("id:" + id);
		
		return "OK";
	}
	
	@ResponseBody // <- Ajax 설정
	@RequestMapping(value = "account.do", method = { RequestMethod.GET, RequestMethod.POST })
	public List<MemberDto> account(MemberDto mem){
		logger.info("HelloController account() " + new Date());
		System.out.println(mem.toString());
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		list.add(new MemberDto("aaa", "111", "AAA", "Aaa", 0));
		list.add(new MemberDto("bbb", "222", "BBB", "Bbb", 0));
		list.add(new MemberDto("ccc", "333", "CCC", "Ccc", 0));
		// 자동적으로 JSON으로 넘어간다
		return list;
	}
	
	@ResponseBody // <- Ajax 설정
	@RequestMapping(value = "read.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> read(){
		logger.info("HelloController read() " + new Date());
		
		// 포장
		String name = "박정현";
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		list.add(new MemberDto("abc", "123", "성춘향", "abc@naver.com", 0));
		list.add(new MemberDto("bcd", "234", "정수동", "bcd@naver.com", 0));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("list", list);
		
		return map;
	}
	
}	
