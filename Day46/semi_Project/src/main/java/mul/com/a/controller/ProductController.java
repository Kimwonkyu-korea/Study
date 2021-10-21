package mul.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
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
	
	// 1. 상품 전체 목록
	@RequestMapping("/productlist.do")
	public String productlist(Model model) {
		logger.info("ProductController drinklist " + new Date());
		
		model.addAttribute("list", service.listProduct());
		
		return "/product/productlist";
		
	}
	
	// 2. 상품 상세보기
	@RequestMapping("/productdetail.do")
	public String productdetail(HttpServletRequest req,Model model) {
		logger.info("ProductController drinkdetail " + new Date());
		
		int prd = Integer.parseInt(req.getParameter("productId"));
		model.addAttribute("dto", service.detailProduct(prd));
		return "/product/productDetail";
	}
	
}
