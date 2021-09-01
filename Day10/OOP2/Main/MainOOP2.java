package Main;

import cal.CalculatorOOP;
import mycls.myOOP2;

public class MainOOP2 {
	
	public static void main(String[] args) {
		/*
		// class 할당, 객체생성
		myOOP2 cls = new myOOP2();
		// cls : object, instance(주체)
		// stack, heap, static, system
		// stack : cls
		// heap : new myOOP2()
		
		System.out.println(cls);	//heap 영역의 주소
		
		cls.number = 1011;
		cls.name = "홍길동";
		cls.height = 177.2;
		
		cls.method();
		cls.func();
		*/
		
		CalculatorOOP ca = new CalculatorOOP();
		
		ca.input();
		ca.calculator();
		ca.print();
		
	}
}
