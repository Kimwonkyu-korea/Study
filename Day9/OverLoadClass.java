
public class OverLoadClass {

	public static void main(String[] args) {
		/*
		 	Over Load : 함수(method)명은 같으며
		 				매개 변수의 자료형이나 갯수가 다른 것을 의미한다.
		 				
		 	print()
		 	print(int i)
		 	print(char c)
		 	print(int i, char c)
		 	print(char c, int i)		
		 				
		 	// background(배경)
		 	painting();
		 	// image			
		 	painting(int x, int y);
		 	painting(int x, int y, int a);
		 */
		
		method();
		
		method('A');
		
		method(3);
		
		method('B', 7);
		
		method(5, 'A');
	}
	
	static void method() {
		System.out.println("method() 호출");
	}

	static void method(char c) {
		System.out.println("method(char c) 호출");
	}
	
	static void method(int i) {
		System.out.println("method(int i) 호출");
	}
	
	static void method(char c, int i) {
		System.out.println("method(char c, int i) 호출");
	}
	static void method(int i, char c) {
		System.out.println("method(int i, char c) 호출");
	}
	
	/* 안되는 예 
	 	1. 매개변수는 같고 인수만 다를 때
	static void method(int a, char b) {
		System.out.println("method(int i, char c) 호출");
	}
	
	  	2. 리턴 값이 다를 경우
	static int method(char c) {
		System.out.println("method(char c) 호출");
	}
	
	*/
}
