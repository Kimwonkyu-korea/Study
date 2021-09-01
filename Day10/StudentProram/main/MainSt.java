package main;

import java.util.Scanner;

import dao.StudentDao;
import dto.DtoSt;

public class MainSt {

	public static void main(String[] args) {
		/*
		DtoSt dto[] = new DtoSt[10];	// 배열만 생성! 객체를 생성한 것이 아니다.
		
		dto[0] = new DtoSt(1, "홍길동", 90, 100, 80);	// 객체 생성
		
		System.out.println(dto[0].toString());
		
		
		 int arrat[] = new int[10];
		 
		 int number 123;
		 DtoSt st = new DtoSt();
		 */
		/*
		DtoSt arrDto[] = new DtoSt[10]; 	// 배열만 생성
		
		for(int i=0; i <arrDto.length; i++) {
			arrDto[i] = new DtoSt();		// 객체를 생성
		}
		*/
		
		Scanner sc = new Scanner(System.in);
		
		StudentDao dao = new StudentDao();
		
		while(true) {
			System.out.println("1.학생정보 추가");
			System.out.println("2.학생정보 삭제");
			System.out.println("3.학생정보 검색");
			System.out.println("4.학생정보 수정");
			System.out.println("5.학생정보 모두 출력");
			
			
			
			
			System.out.println("어느 작업을 하시겠습니까? ");
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
