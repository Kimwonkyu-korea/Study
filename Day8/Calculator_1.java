import java.util.Scanner;

public class Calculator_1 {

	public static void main(String[] args) {
		
		// 1. 입력
		
		Scanner sc = new Scanner(System.in);
		
		// 1.1 첫번째 숫자
		System.out.print("첫번째 숫자를 입력하세요: ");
		int num1 = sc.nextInt(); 
		// 1.2 연산자 선택
		System.out.print("연산자 +, -, *, / 중 선택하시오: ");
		String Op = sc.next();
		// 1.3 두번째 숫자
		System.out.print("두번째 숫자를 입력하세요: ");
		int num2 = sc.nextInt(); 
		
		// 연산의 결과 값
		int result = 0;
		result = calculate(num1, num2, Op);
		System.out.println(num1 + " " + Op + " " + num2 + " = " + result);
	
		
		// * equals 사용하기
		//	조건 분기
		/*
		if(Op.equals("+")) {
			result = num1 + num2;
		}
		else if(Op.equals("-")){
			result = num1 + num2;
		}
		else if(Op.equals("*")){
			result = num1 + num2;
		}
		else if(Op.equals("/")){
			result = num1 + num2;
		}
		*/
		
		/*
		switch( Op ) {
		case "+":
			result1;
			break;
		case "-":
			result2;
			break;
		case "*":
			result3;
			break;
		case "/":
			result4;
			break;
		}
		*/
	}
	static int calculate(int num1, int num2, String Op) {
		Scanner sc = new Scanner(System.in);

		int result = 0;
		if(Op.equals("+")) {
			result = num1 + num2;
		}
		else if(Op.equals("-")){
			result = num1 - num2;
		}
		else if(Op.equals("*")){
			result = num1 * num2;
		}
		else if(Op.equals("/")){
			result = num1 / num2;
		}	
		return result;
	}

}
