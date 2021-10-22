package mul.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 @RequestMapping(value = "/cartlist.do", method = RequestMethod.GET) 
	 public String cartlist(String user_id, Model model, CartDto dto) {
		 logger.info("CartController cartlist() " + new Date());
		  
		 List<CartDto> list = service.cartlist(user_id);
		 System.out.println(list);
		 
		 model.addAttribute("cartlist", list);
		 model.addAttribute("user_id", user_id);
		 model.addAttribute("dto", dto);

		 return "cart/cartlist";

	 }
	 
	 @RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	 public String delete(CartDto dto,Model model) {
		 logger.info("CartController delete() " + new Date());
		 
		boolean b = service.delete(dto);
		
		if(b == true) {
			return "redirect:/cartlist.do?user_id="+dto.getUser_id()
			+"&order_id="+dto.getOrder_id();
		}
		return "redirect:/cartlist.do";
	 }
	 
	 @RequestMapping(value = "/deleteAll.do", method = RequestMethod.GET)
	 public String deleteAll(CartDto dto,Model model) {
		 logger.info("CartController deleteAll() " + new Date());
		 
		boolean b = service.deleteAll(dto);
		
		if(b == true) {
			return "redirect:/cartlist.do?user_id="+dto.getUser_id();
		}
		return "redirect:/cartlist.do";
	 }
	 
	 @RequestMapping(value="/ordercheck.do", method = RequestMethod.POST)
	public String ordercheck(Model model, CartDto dto, HttpServletRequest req, HttpSession session) {
		
		String  productName = req.getParameter("productName");
		int productId = Integer.parseInt(req.getParameter("productId"));
		int productPrice = Integer.parseInt(req.getParameter("productPrice"));
		int amount = Integer.parseInt(req.getParameter("amount"));
		int total_price  = productPrice * amount;
		String userId = (String)session.getAttribute("id");
		
		System.out.println("id라네용 : "+session.getAttribute("id"));
		
		
		dto.setProduct_id(productId);
		dto.setProduct_name(productName);
		dto.setProduct_price(productPrice);
		dto.setTotal_price(total_price);
		dto.setOrder_count(amount);
		dto.setUser_id(userId);
		
		boolean b = service.insertProduct(dto);
		
		String insert = "NO";
		if(b) {
			insert = "YES";
		}
		model.addAttribute("insert", insert);
		
		return "message2";
		
	//	logger.info("CartController ordercheck()" + new Date());
		
	//	List<CartDto> list = service.ordercheck(dto);
	//	model.addAttribute("orderlist", list);
		
	//	System.out.println(list);
		
	//	return "cart/ordercheck";
	}
		
	@RequestMapping(value="/paysuccess.do", method = RequestMethod.GET)
	public String paysuccess() {
		return "cart/paysuccess";
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
