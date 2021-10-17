package mul.com.a.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mul.com.a.dto.ProductDto;
import mul.com.a.service.MemberService;

@Controller
public class ProductController {

	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "product.do", method = RequestMethod.GET)
	public String product() {
		logger.info("MemberController login " + new Date());
		
		
		return "product/product";
	}
	
	
}
