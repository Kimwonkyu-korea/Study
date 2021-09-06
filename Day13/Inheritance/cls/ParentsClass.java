package cls;

public class ParentsClass extends Object{ // extends Object -> 생략은 가능, 최상위 클래스이다
	
	private String name;
	protected int number;
	public int age;
	// protected -> 자식 클래스에서만 접근 허용(요즘은 사용을 잘 안하는 추세)
	
	/*
	public ParentsClass() {
		System.out.println("ParentsClass ParentsClass()");
	}
	*/
	public ParentsClass(String name, int number) {
	//	this();
		this.name = name;
		this.number = number;
	}
	
	
	

	public ParentsClass(String name, int number, int age) {
		super();
		this.name = name;
		this.number = number;
		this.age = age;
	}




	public void pMethod() {
		System.out.println("ParentsClass pMethod()");
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
