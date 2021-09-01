package main;

import cls.MyClass;

public class MainConst {

	public static void main(String[] args) {
		/*
		 	Constructor : 	생성자
		 					초기화 함수(메소드)
		 					클래스명과 같다.
		 					return 값이 없다.
		 					over load가 가능하다.
		 					class 생성 시 자동 호출된다.
		 					따로 호출이 불가능하다.	
		 					생략이 가능하다.
		 */
		
		int array[] = { 1, 2, 3, 4 };	// 같은 자료형의 묶음이다.
		/*
		
		 	structure == 구조체 =>  C언어
		 	
		 	struct MTSTRUCT{
		 		int number;
		 		String name;
		 		double height;
		 	};
		 	
		 	MTSTRUCT st = { 1, "문자열", 123.45 } ;
		 */
		
//		MyClass cls = new MyClass();
		
//		Myclass mycls = { 1, "문자열", 123.45 } ;	 오류
		
//		MyClass cls = new MyClass();
//		
//		MyClass cls1 = new MyClass('A');
//
//		MyClass cls2 = new MyClass(1, "문자열", 123.45);
//		
//		cls2.init(1, "문자열", 123.45);
	
		MyClass cls3 = new MyClass(1);
	}

}
/*
class MyClass{

	int number;
	String name;
	double height;
}
*/