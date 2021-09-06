package cls;

public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("ChiledClass ChildClass()");
	}
	public void method() {	// Over Ride : 상속받은 메소드를 고쳐 기입한다.
		System.out.println("ChildClass method()");
	}
	
	public void process() {
		super.method();		// 위에 있는 메소드
		this.method();      // this  생략가능
	}
}
