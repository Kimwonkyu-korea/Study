package main;

import dto.DtoMember;

public class MainOOP3 {

	public static void main(String[] args) {
		/*
		 	Object Oriented Programming
		 	
		 	1. 은닉성(캡슐화)
		 	- 변수를 외부에 노출하는 규칙
		 	2. 상속성
		 	- 상위(super) 클래스에서 좋은 기능(메소드)등을 상속
		 	3. 다형성 - 여러가지 형태
		 	- 상속을 받은 후에 다양한 처리
		 	
		 	Encapsulation == 은닉성, 캡슐화
		 	
		 	접근 지정자
		 	private : 개인적인
		 	public : 대중적인
		 	protected : 상속에 관련한 처리
		 */
		
		DtoMember mem = new DtoMember();	// 오브젝트 생성
		
//		mem.number = 1;
		mem.name = "홍길동";
//		mem.height = 176.2;
		
		mem.setNumber(123);
		
		int n = mem.getNumber();
		System.out.println("Heap 영역의 주소1 : " + mem);
		System.out.println(n);
		
//		DtoMember obj = new DtoMember();
//		System.out.println("Heap 영역의 주소2 : " + obj);
		
		System.out.println("자기참조 : " + mem.getThis()); // 자기 참조
		
	}

}
