package mul.com.a.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mul.com.a.dto.CartDto;
import mul.com.a.dto.ProductDto;
import mul.com.a.service.ProductService;

@Controller
public class ProductController {

	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService service;
	
	@RequestMapping(value = "product.do", method = RequestMethod.GET)
	public String product() {
		logger.info("ProductController product() " + new Date());
		
		return "product/product";
	}
	
	@RequestMapping(value = "productAf.do", method = RequestMethod.POST)
	public String product(CartDto dto, Model model) {
		logger.info("ProductController product() " + new Date());
		
		boolean b = service.product(dto);
		String cart = "NO";
		if(b) {
			cart = "YES";
		}
		model.addAttribute("cart", cart);
		
		return "message2";
	}
	
}
