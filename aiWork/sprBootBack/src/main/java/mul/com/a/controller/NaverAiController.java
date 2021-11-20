package mul.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mul.com.a.naver.NaverCloud;

@RestController
public class NaverAiController {

	@Autowired
	ServletContext servletContext;

	// 음성인식 wsv -> String
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String fileUpload( @RequestParam("uploadFile")
	MultipartFile uploadFile, 
	HttpServletRequest req,
	String message) {

		System.out.println("PdsController fileUpload()");

		System.out.println("message:" + message);

		// 경로	사라질수 있다.
		String uploadPath = req.getServletContext().getRealPath("/upload");

		// 폴더
		// String uploadPath = "C:"

		// 파일명 취득
		String filename = uploadFile.getOriginalFilename();
		String filepath = uploadPath + File.separator + filename;		// '/'


		System.out.println(filepath);

		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadFile.getBytes());
			os.close();

			// DB input 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}

		// Naver AI
		String resp = NaverCloud.processSTT(filepath);


		return resp;
	}

	// 얼굴인식 jpg -> String
	@RequestMapping(value = "/cfr_fileUpload", method = RequestMethod.POST)
	public String cfr_fileUpload( @RequestParam("uploadFile")
	MultipartFile uploadFile, 
	HttpServletRequest req,
	String message) {

		System.out.println("PdsController cfr_fileUpload()");

		System.out.println("message:" + message);

		// 경로	사라질수 있다.
		String uploadPath = req.getServletContext().getRealPath("/upload");

		// 폴더
		// String uploadPath = "C:"

		// 파일명 취득
		String filename = uploadFile.getOriginalFilename();
		String filepath = uploadPath + File.separator + filename;		// '/'


		System.out.println(filepath);

		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadFile.getBytes());
			os.close();

			// DB input 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}

		// Naver AI
		String resp = NaverCloud.processCFR(filepath);


		return resp;
	}

	// 문자열 -> 음성파일(mp3)
	@RequestMapping(value = "/tts_proc", method = RequestMethod.POST)
	public String tts_proc(String str, HttpServletRequest req) {
		System.out.println("PdsController tts_proc()");
		System.out.println("str:" + str);

		String uploadPath = req.getServletContext().getRealPath("/upload");
		System.out.println(uploadPath);

		boolean b = NaverCloud.processTTS(str, uploadPath);
		if(b == true) {
			return "OK";
		}else {
			return "NG";
		}

	}

	@RequestMapping(value = "/obj_detect", method = RequestMethod.POST)
	public String obj_detect(@RequestParam("uploadFile") MultipartFile uploadFile, 
			HttpServletRequest req){
		System.out.println("PdsController obj_detect()");

		// 경로	사라질수 있다.
		String uploadPath = req.getServletContext().getRealPath("/upload");

		// 폴더
		// String uploadPath = "C:"

		// 파일명 취득
		String filename = uploadFile.getOriginalFilename();
		String filepath = uploadPath + File.separator + filename;		// '/'


		System.out.println(filepath);

		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadFile.getBytes());
			os.close();

			// DB input 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}

		String text = NaverCloud.objectDetction(filepath);


		return text;
	}
	
	@RequestMapping(value = "/chatbot", method = RequestMethod.POST)
	public String chatbot(String msg) {
		System.out.println("PdsController chatbot()");
		// html에서 입력한 msg를 가져와서 str에 넣어준다.
		String str = NaverCloud.chatBot(msg);
		
		return str;
	}

}
