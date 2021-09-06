package cls;

public class ChildClass extends ParentsClass{  //extends ParentsClass -> ParentsClass를 상속받는다
	private String address;
	public ChildClass() {
		super("성춘향", 16);    // this() : 자기참조  super() : 부모 클래스 참조  -> this()와 super()는 같이 사용할 수 없다. 메소드 맨위에 위치해 있어야만 한다.
		System.out.println("ChildClass ChildClass()");
	}
	
	public void func() {
		System.out.println("ChildClass func()");
		
		
	//	name = "일지매";
		
		setName("일지매");
		
		number = 34;
		
		age = 24;
		
		
	}

	public ChildClass(String name, int number, String address, int age) {
		super(name, number, age);
		this.address = address;
	}
	

}
