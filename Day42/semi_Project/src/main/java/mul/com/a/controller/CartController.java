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

import mul.com.a.dto.CartDto;
import mul.com.a.service.CartService;


@Controller
public class CartController {
	
	private static Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	CartService service;
	
	
	 @RequestMapping(value = "cartlist.do", method = RequestMethod.GET) 
	 public String cartlist(String user_id, Model model) {
		 logger.info("CartController cartlist() " + new Date());

		 // Map<String, Object> map = new HashMap<>(); // HashMap 생성 List<CartDto>
		 List<CartDto> list = service.cartlist(user_id);
		 System.out.println(list);
		 model.addAttribute("cartlist", list);

		 return "redirect:/cartlist.do";

	 }

}
