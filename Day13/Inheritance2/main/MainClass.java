package main;

import cls.ChildClass;
import cls.ParentClass;

public class MainClass {

	public static void main(String[] args) {

		ChildClass cc = new ChildClass();
		//cc.method();
		//cc.func();
		
		//cc.process();
		// 객체 : 부모 		생성 : 자식
		ParentClass pc = new ChildClass();
		
		//pc.method();
		
		//pc.func();
		
		ChildClass c = (ChildClass)pc;	// 강제형변환
		
		c.process();
	}

}
