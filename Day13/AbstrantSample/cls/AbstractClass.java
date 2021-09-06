package cls;

public abstract class AbstractClass {
	
	private int number;		// 멤버 변수
	
	public void method() {	// 일반 멤버 메소드
		System.out.println("AbstractClass method()");
	}
	
	public  abstract void abstractMethod();
}
