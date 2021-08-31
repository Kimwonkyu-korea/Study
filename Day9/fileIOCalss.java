package fileIO;

import java.io.File;
import java.io.IOException;

public class fileIOCalss {

	public static void main(String[] args) {
		/*
		  	file : 저장 매체 == 기능
		  			Database(file)
		  
		  	*.txt -> 2진수 -> dll, lib, jar, bmp
		 */
		
		File file = new File("c:\\");
		/*
		// 파일 조사
		String filelist[] = file.list();
		
		for(int i =0 ; i < filelist.length; i++) {
			System.out.println(filelist[i]);
		}
		*/
		
		// 파일과 폴더(dir)
		/*
		File filelist[] = file.listFiles();
		for(int i =0 ; i < filelist.length; i++) {
			if(filelist[i].isFile()) {
				System.out.println("[파일]" + filelist[i].getName());
			}
			else if(filelist[i].isDirectory()) {
				System.out.println("[폴더]" + filelist[i].getName());
			}
			else {
				System.out.println("[?]" + filelist[i].getName());
			}
		}
		*/
		// 파일 생성
		File newfile = new File("C:\\Test\\newfile.txt");

		try {
			if(newfile.createNewFile()) {
				System.out.println("파일 생성 성공!");
			}
			else {
				System.out.println("파일 생성 실패");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//폴더 생성
		File newdir = new File("C:\\Test\\subdir");
		if(newdir.mkdirs()) {
			System.out.println("폴더 생성 성공!");
		}
		else {
			System.out.println("폴더 생성 실패");
		}
		
		// file의 존재 여부
		if(newfile.exists()) {
			System.out.println("newfile.txt가 존재합니다.");
		}else {
			System.out.println("newfile.txt가 존재하지 않습니다.");
		}
		
		
		
		// file의 읽기 가능 여부
		if(newfile.canRead()) {
			System.out.println("이 파일은 읽기가 가능합니다.");
		}else {
			System.out.println("이 파일은 쓰기가 불가능합니다.");
		}
		
		// 읽기 전용
				newfile.setReadOnly();
				
		// file의 쓰기 가능 여부
		if(newfile.canWrite()) {
			System.out.println("이 파일은 읽기가 가능합니다.");
		}else {
			System.out.println("이 파일은 쓰기가 불가능합니다.");
		}
		
		// 삭제 
		newfile.delete();
	}
}
