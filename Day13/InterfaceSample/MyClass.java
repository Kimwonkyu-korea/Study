package main;

public class MyClass implements MyInterface{	// Interface는 implements

	@Override
	public void method() {
		System.out.println("MyClass method()");
	}

	@Override
	public void func() {
		System.out.println("MyClass func");
	}
}
