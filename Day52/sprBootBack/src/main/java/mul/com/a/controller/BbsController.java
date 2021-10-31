package mul.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;
import mul.com.a.service.BbsService;

@RestController
public class BbsController {
	
	@Autowired
	BbsService service; 
	
	// 'http://localhost:3000/bbslist'
	@RequestMapping(value = "/bbslist", method = RequestMethod.GET)
	public List<BbsDto> bbslist(BbsParam param){ // 리턴 값 List<BbsDto>
		System.out.println("BbsController bbslist()");
		
		int sn = param.getpage();	// 0 1 2	페이지 수
		int start = sn * 10 +1;		// 1 11 21 	
		int end = (sn + 1 ) * 10;	// 10 20 30 
		
		param.setStart(start);	// param start 값 담는다
		param.setEnd(end);		// param end 값 담는다
		
		List<BbsDto> list = service.getbbslist(param);
		
		return list;
	}
	
	@RequestMapping(value = "/bbscount", method = RequestMethod.GET)
	public int bbscount(BbsParam param) {
		System.out.println("BbsController bbscount()");
		
		return service.getbbscount(param);
	}
	
	@RequestMapping(value = "/bbswrite", method = RequestMethod.GET)
	public String bbswrite(BbsDto bto) {
		System.out.println("BbsController bbswrite()");
		
		boolean b = service.writeBbs(bto);
		if(b == true) {
			return "OK";
		}else {
			return "NG";
		}	
	}
	
	@RequestMapping(value = "/bbsdetail", method = RequestMethod.GET)
	public BbsDto bbsdetail(int seq) {
		System.out.println("BbsController bbsdetail()");
		
		return service.getBbs(seq);
	}
	// 글 수정
	@RequestMapping(value = "/bbsupdate", method = RequestMethod.GET)
	public String bbsupdate(BbsDto bto) {
		System.out.println("BbsController bbsupdate()");
		
		boolean b = service.updateBbs(bto);
		if(b == true) {
			return "OK";
		}else {
			return "NG";
		}	
	}
}
