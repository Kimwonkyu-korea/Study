package mul.com.a;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller		// <- annotation
public class HomeController {
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("home")
	public String helloMethod() {
	//	System.out.println("HomeController helloMethod()");
		logger.info("HomeController helloMethod() " + new Date());
		
		return "home";		// <- home.jsp로 이동
	}
	
	@RequestMapping(value = "hello.do")
	public String hello(Model model) {	// Model <- 짐을 포장하기 위한 interface
		logger.info("HomeController hello() " + new Date());
		
		String name = "홍길동";
		
		model.addAttribute("name", name);	// 짐싸! == setAttribute
		
		return "hello"; 	// <- hello.jsp로 이동
	}
	/*
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	// 전달 받을 값이 같아야된다.
	public String home(String name, int age) {	// hello.jsp로 부터 전달 받는 값, spring 자동으로 바꿔줌 parsing x
		logger.info("HomeController home() " + new Date());
		
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		
		return "hello";		// <- hello.jsp로 이동
	}*/
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	// 전달 받을 값이 같아야된다.
	public String home(Model model ,Human human) {	// 자동생성
		logger.info("HomeController home() " + new Date());
		
		System.out.println("name:" + human.getName());	// 객체 안 값
		System.out.println("age:" + human.getAge());
		
		model.addAttribute("human", human);
		
		return "hello";		// <- hello.jsp로 이동
	}
}
