
public class MethodClass {

	public static void main(String[] args) {
		/*
		 	function 함수
		 	method 함수
		 	
		 	형식 : 
		 	
		 	return값의 자료형 함수명( 인수, 인자, 매개변수, parameter ){
		 		
		 		처리
		 		
		 		return 값;
		 	}
		 	
		 	void -> 자료형이 없는 형태
		  
		 */
		functionName();
		
		funcName(123); // argument
		
		double d = func();
		System.out.println("d = " + d);
		
		int n = func1('A', "Hello");
		System.out.println("n = " + n);
		
		int array[] = {11, 22, 33 };
	
		int r = numberSet(array);
		System.out.println("r = " + r);
		
		int rArr[] = getArray();
		for(int num : rArr) {
			System.out.println(num);
		}
		
		int num1, num2;
		num1 = 24;
		num2 = 7;
		
		int result = plus(num1, num2);
		System.out.println(num1 + " + " + num2 + " = " + result);
	//	System.out.println(num1 + "+" + num2 + "=" + plus(num1, num2));
	}
	
	static void functionName() {
		System.out.println("functionName() 호출");
	}
	
	static void funcName(int n) {	// 파라미터(매개 변수)
		System.out.println("funcName(int n) 호출 n = " + n);
	}
	
	static double func() {
		System.out.println("func() 호출");
		
		double d = 123.456;
		return d; 
		
	//  return 234.567;
	}
	
	static int func1(char c, String str) {
		System.out.println("func1(char c, String str) 호출");
		
		System.out.println("c = " + c);
		System.out.println("str = " + str);
		
		return 27;
	}
	
	static int numberSet(int arr[]) {
		System.out.println("numberSet(int arr[] 호출");
		
		for (int i =0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		return arr[2];
	}
	
	static int[] getArray() {
		
		System.out.println("getArray() 호출");
	
		int array[] = new int[3];
		array[0] = 111;
		array[1] = 222;
		array[2] = 333;
		
		return array;
	}
	static int plus(int n1, int n2) {
		int r;
		r = n1 + n2;
		return r;
	}		
}
