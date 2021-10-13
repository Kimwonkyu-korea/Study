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

import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;
import mul.com.a.service.BbsService;

@Controller
public class BbsController {

	private static Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	BbsService service;
	
	@RequestMapping(value = "bbslist.do", method = RequestMethod.GET)
	public String bbslist(Model model, BbsParam param) {
		logger.info("BbsController bbslist() " + new Date());
		
		// 현재 페이지
		int pageNumber = 0;
		if(param != null) {	// 매개변수로 넘어 온 값이 있으면..  
			pageNumber = param.getPageNumber();
		}
		model.addAttribute("pageNumber", pageNumber);
		
		// 페이지
		int start, end;
		start = 1 + 10 * pageNumber;
		end = 10 + 10 * pageNumber;
		
		param.setStart(start);
		param.setEnd(end);
		
		List<BbsDto> list = service.getBbsList(param);
		model.addAttribute("bbslist", list);
		
		
		model.addAttribute("choice", param.getChoice());
		model.addAttribute("search", param.getSearch());
		
		// 총 글의 수 갖고오기
		int allbbs = service.getAllBbs(param);
		// 총 페이지 수
		Integer bbsPage = allbbs / 10;		// 29 / 10 -> 2
		if((allbbs % 10) > 0){
			bbsPage = bbsPage + 1;
		}
		model.addAttribute("bbsPage", bbsPage);
				
	//	return "bbs/bbslist";		
		return "main";
	}
	
	@RequestMapping(value = "bbswrite.do", method = RequestMethod.GET)
	public String bbswrite(Model model) {
		logger.info("BbsController bbswrite() " + new Date());
		model.addAttribute("content", "bbswrite");
		return "main";
	}
	
	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
	public String bbswriteAf(BbsDto bbs) {
		logger.info("BbsController bbswriteAf() " + new Date());
		
		boolean b = service.writeBbs(bbs);
		if(b == true) {
			return "redirect:/bbslist.do";
		}
		
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsdetail.do", method = RequestMethod.GET)
	public String bbsdetail(int seq, Model model) {
		logger.info("BbsController bbsdetail() " + new Date());
		
		BbsDto bbs = service.getBbs(seq);
		model.addAttribute("bbs", bbs);
		
		model.addAttribute("content", "bbsdetail");
		return "main";
	}
	
	@RequestMapping(value = "bbsanswer.do", method = RequestMethod.GET)
	public String answerUpdate(int seq, Model model) {
		logger.info("BbsController answerUpdate() " + new Date());
		
		boolean b = service.answerUpdate(seq);
		model.addAttribute("seq", b);
		
		return "main";
	
	}
	
	@RequestMapping(value = "bbsanswerAf.do", method = RequestMethod.GET)
	public String answerInsert(BbsDto bbs, Model model) {
		logger.info("BbsController answerInsert() " + new Date());
		
		boolean bbsInsert = service.answerInsert(bbs);
		model.addAttribute("bbs", bbs);
		
		return "main";
	}
	
	@RequestMapping(value = "bbsupdate.do", method = RequestMethod.GET)
	public String bbsupdate(String seq, Model model) {
		logger.info("BbsController bbsupdate() " + new Date());
		
		int sseq = Integer.parseInt(seq);
		service.readcount(sseq);	// 조회수
		
		BbsDto dto = service.getBbs(sseq);
		
		model.addAttribute("seq", seq);
		model.addAttribute("bbs", dto);
		
		return "bbs/bbsupdate";
	}
	
	@RequestMapping(value = "bbsupdateAf.do", method = RequestMethod.POST)
	public String bbsupdateAf(String seq, BbsDto bbs, Model model) {
		logger.info("BbsController bbsupdateAf() " + new Date());
		
		int sseq = Integer.parseInt(seq);
		service.readcount(sseq);
		
		model.addAttribute("seq", seq);
		model.addAttribute("bbs", bbs);
		
		boolean b = service.updateBbs(bbs);
		if(b == true) {
			return "bbs/bbsupdete" + sseq;
		}
		
		return "bbs/bbslist";
		
	}
	
}
