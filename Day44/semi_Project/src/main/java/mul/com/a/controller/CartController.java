package mul.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mul.com.a.dto.CartDto;
import mul.com.a.dto.MemberDto;
import mul.com.a.service.CartService;


@Controller
public class CartController {
	
	private static Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	CartService service;
	
	
	 /* 
	 @RequestMapping(value = "cartlist.do", method = RequestMethod.GET) 
	 public String cartlist(String user_id, Model model) {
		 logger.info("CartController cartlist() " + new Date());

		 // Map<String, Object> map = new HashMap<>(); // HashMap 생성 List<CartDto>
		 List<CartDto> list = service.getCartList(user_id);
		 System.out.println(list);
		 model.addAttribute("cartlist", list);

		 return "cart/cartlist";

	 } 
	 
	 */
	 @RequestMapping(value = "cartlist.do", method = RequestMethod.GET) 
	 public String cartlist(String user_id, Model model, CartDto dto) {
		 logger.info("CartController cartlist() " + new Date());
		  
		 List<CartDto> list = service.cartlist(user_id);
		 System.out.println(list);
		 
		 model.addAttribute("cartlist", list);
		 model.addAttribute("user_id", user_id);
		 model.addAttribute("dto", dto);

		 return "cart/cartlist";

	 }
	 
	 @RequestMapping(value = "delete.do", method = RequestMethod.GET)
	 public String delete(CartDto dto,Model model) {
		 logger.info("CartController delete() " + new Date());
		 
		boolean b = service.delete(dto);
		
		if(b == true) {
			return "redirect:/cartlist.do?user_id="+dto.getUser_id()
			+"&order_id="+dto.getOrder_id();
		}
		return "redirect:/cartlist.do";
	 }
	 
	 
	 
/*	 
	 @RequestMapping(value = "sumprice.do", method = RequestMethod.GET)
	 public String sumprice(String user_id, Model model) {
		 logger.info("CartController sumprice() " + new Date());
		 
		 int sumprice = service.sumprice(user_id);
		 model.addAttribute("sumprice" ,sumprice);
		 
		return "cart/cartlist";
	 } */

}
