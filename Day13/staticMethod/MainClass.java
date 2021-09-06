package main;

import java.util.Calendar;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	멤버 메소드 : class에 소속되어 있는 함수
		 				instance 메소드
		 				
		 	정적 메소드 : class에 소속되어 있는 함수
		 				class 메소드
		 				
		 */
		MyClass cls = new MyClass();
		cls.memberMethod();
		
		MyClass.staticmethod(); 	//static 메소드는 클래스명을 통해서 호출
		
		MyClass mycls = MyClass.getInstance();
		
		Calendar cal = Calendar.getInstance();
	}
	
	static void method() {
		System.out.println("method()");
	}
}
