package main;

public class MyClass {
	
	static int stNumber;
	int memVar;
	
	public void memberMethod() {
		System.out.println("MyClass memberMethod()");
	}
	
	public static void staticmethod() {
		System.out.println("MyClass staticmethod");
		
		// this, super는 사용할 수 없다.
		// this.memVar = 1;
	}
	
	public static MyClass getInstance() {	
		MyClass m = new MyClass();
		m.memVar = 1;
		// 초기화 할 값이 많다.
		
		return m;
	}
}
