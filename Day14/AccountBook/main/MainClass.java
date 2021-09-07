package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.AccountBookDao;

public class MainClass {

	public static void main(String[] args) {
		/*
		  	가계부
		 	
		 	날짜 2021/09/07
		 	금액 
		 	수입/지출
		 	제목
		 	내용
		 	
		 	추가
		 	삭제
		 	검색(제목, 날짜) 1번제목 2번날짜(년월일 다 입력)
		 	수정
		 	모두 출력
		 	ArrayList 
		 	파일저장, 불러오기
		 */
		// 날짜
		
		Scanner sc = new Scanner(System.in);
		
		
		AccountBookDao dao = new AccountBookDao();
		
		while(true) {
			System.out.println("1.가계부 추가하기");
			System.out.println("2.가계부 삭제하기");
			System.out.println("3.가계부 검색하기");
			System.out.println("4.가계부 수정하기");
			System.out.println("5.가계부 내역보기");
			
			System.out.println("어느 작업으로 하시겠습니까? ");
			System.out.print(">> ");
			
			int work = sc.nextInt();
			
			switch(work) {
			case 1:
				dao.Create();
				break;

			case 2:
				dao.Delete();
				break;
				
			case 3: 
					dao.Read();	

				break;

			case 4:
				dao.Update();
				break;

			case 5:
				dao.allprint();
				break;
			}
		}
		
	}

}