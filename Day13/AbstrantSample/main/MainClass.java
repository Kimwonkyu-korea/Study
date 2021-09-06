package main;

import cls.AbstractClass;
import cls.MyClass;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	Abstrant Class : 추상 클래스
		 					 추상 메소드를 하나이상 포함하고 있는 클래스
		 					 내용은 없고, 선언만 되어 있는 메소드
		 					 
		 	public void method(int n){	<- prototype(사양)
		 		처리
		 	}
		 			
		 	public abstract void method(int n);		// 추정해서 선언만 해 놓는다.		
		 	
		 */
//		AbstractClass acls = new AbstractClass(); 안된다
		// 여러번 쓸 때
		MyClass cls = new MyClass();
		cls.method();
		cls.abstractMethod();
		
		AbstractClass acls = new AbstractClass() {
			
			@Override
			public void abstractMethod() {
				System.out.println("AbstractClass abstractMethod()");
			}
		};
		
		acls.method();
		acls.abstractMethod();
	}

}
