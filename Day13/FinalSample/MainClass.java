
public class MainClass {

	public static void main(String[] args) {
		/*
		 	final
		  	변수, 메소드, 클래스
		 
		 */
		
		final int NUMBER = 10;	// 상수 number, 값을 정해야된다.
		int num = NUMBER;	// 대입용
		
		ChildClass cc =new ChildClass();
		cc.method();
	}

}

// 상속 금지
/*final*/class SuperClass{
	
	// Over Ride 금지!
	public/*final*/void method() {
		System.out.println("SuperClass method()");
	}
}

class ChildClass extends SuperClass{
	
	public void method() {	// Over Ride
		System.out.println("ChildClass method()");
	}
}