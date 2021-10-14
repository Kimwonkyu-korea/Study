package mul.com.a.util;

import java.util.Date;

public class PdsUtil {
	
	// abc.txt -> 46564565.txt
	public static String setNewFileName(String filename) {	// PdsUtil.setNewFileName 바로 사용
		String newfilename = ""; // 새로운 파일명(리턴 명)
		String filepost = "";	// 확장자명
		
		if(filename.indexOf('.') >= 0 ) {	// 확장자명이 있는 경우
			filepost = filename.substring( filename.indexOf('.') );	// abc.txt
			newfilename = new Date().getTime() + filepost;	// 시간 + 확장자명
			
		}else {		// 확장자명이 없는 경우
			newfilename = new Date().getTime() + ".back";
		}
		
		return newfilename;
	}
}
