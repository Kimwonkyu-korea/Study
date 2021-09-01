package cls;

public class MyClass {
	
	private int number;
	private String name;
	private double height;
	
	public MyClass() {	// 많이 사용
		System.out.println("MyClass MyClass()");
		number = 10;
		name = "빈칸";
		height = 100.0;
	}
	
	public MyClass(char c) {
		System.out.println("MyClass MyClass(char c))");
	}
	
	public MyClass(int number, String name, double height) { // 많이 사용
		System.out.println("MyClass MyClass(int number, String name, double height)");
		this.number = number;
		this.name = name;
		this.height = height;
	}
	
	public void init(int number, String name, double height) {
		this.number = number;
		this.name = name;
		this.height = height;
	}
	
	public MyClass(int i) {
		this('A');	 // 맨 윗줄
		
		System.out.println("MyClass MyClass(int i)");
	}
}
