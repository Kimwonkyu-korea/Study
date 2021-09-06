package cls;

public class MyClass {
	
	private int number = 0;	// member -> heap
	
	public static int static_var = 0;	// static -> global(전역) variable
	
	final int MEMBERNUMBER = 100;	// 상수(정해진 수), 위에서 설정
	
	public void method(char c, int n) {		// 매개변수 -> stack
		
		int mem = MEMBERNUMBER;	
		
		c = 'A';
		c = 'T';
		
		int num = 0; //  local -> stack 지역변수 

		num++;
		
		number++;	// instance(member) 변수
		
		MyClass.static_var++;	// static
		
		System.out.println("local 변수 = " + num);
		System.out.println("member 변수 = " + number);
		System.out.println("static 변수 = " + MyClass.static_var);
	}
}
