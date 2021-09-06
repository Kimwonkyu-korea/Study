package main;

import cls.MyClass;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	Variable : 변수
		 	
		 				local		지역
		 				static		정적
		 				parameter	=지역
		 				member		=클래스 소속
		 				
		 				memory	stack	heap	static	system
		 						  O
		 						  				   O
		 						  O
		 						   		  O
		 */
		

		int number; // local
		
		MyClass cls = new MyClass();
		
		cls.method('B', 1);
		cls.method('B', 1);
		cls.method('B', 1);
		
		MyClass cls1 = new MyClass();	
		
		cls1.method('B', 1); 	// instance가 다르다.
		
		MyClass.static_var++;	// 언제 어디서든 접근이 가능하다.
		
		cls1.method('B', 1);
	}

}
