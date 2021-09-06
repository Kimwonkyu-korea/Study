package main;

import cls.ChildClass;
import cls.ParentsClass;

public class InheritanceClass {

	public static void main(String[] args) {
		/*
		   inheritance : 상속
		   
		   부모클래스 -> 자식 클래스(부모클래스로부터 상속을 받고싶음)
		   variable(변수)
		   method(함수) -> 둘다 상속
		*/
		
	//	ParentsClass pc = new ParentsClass("홍길동", 1001);
	//	pc.pMethod();
		
		ChildClass cc = new ChildClass();
		cc.pMethod();
		
	//	cc.number = 123;
		cc.age = 12;
		
		ChildClass cc1 =  new ChildClass("김철수", 1002, " 서울시", 25);

	}

}
