package main;

import java.util.Scanner;

import Book.BookDao;
import Magazine.MagazineDao;

public class MainMenu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BookDao Bdao = new BookDao();
		MagazineDao Mdao = new MagazineDao();


		// 책(Book)을 선택

		while(true) {
			System.out.println("------ 도서 종류를 선택하세요 ------");
			System.out.print("1.책(Book) \t 2.잡지(Megazine) \n>>");
			
			// 책(Book)과 잡지(Megazine) 선택
			int pick = sc.nextInt();
			if(pick == 1) {	
				
				System.out.println("1.책(Book)목록 추가하기");
				System.out.println("2.책(Book)목록 조회하기");
				System.out.println("3.책(Book)목록 파일저장하기");
				System.out.println("4.책(Book)목록 파일불러오기");

				System.out.println("어느 작업으로 하시겠습니까? ");
				System.out.print(">> ");

				int work1 = sc.nextInt();
				// 번호 선택 시 해당 번호 기능 실행
				switch(work1) {

				case 1:
					Bdao.insert();
					break;

				case 2:
					Bdao.select();
					break;

				case 3: 
					Bdao.filesave();	
					break;

				case 4:
					Bdao.fileload();
					break;
				}
			}
			else if(pick == 2){		// 잡지(Megazine)을 선택
				System.out.println("1.잡지(Megazine)목록 추가하기");
				System.out.println("2.잡지(Megazine)목록 조회하기");
				System.out.println("3.잡지(Megazine)목록 파일저장하기");
				System.out.println("4.잡지(Megazine)목록 파일불러오기");

				System.out.println("어느 작업으로 하시겠습니까? ");
				System.out.print(">> ");

				int work2 = sc.nextInt();
				// 번호 선택 시 해당 번호 기능 실행
				switch(work2) {
				case 1:
					Mdao.insert();
					break;

				case 2:
					Mdao.select();
					break;

				case 3: 
					Mdao.filesave();	

					break;

				case 4:
					Mdao.fileload();
					break;
				}
			}else {	// 예외 값이 들어올 경우
				System.out.println("잘못 입력하셨습니다. 숫자로 입력하세요.\n");
			}
		}
	}
}





