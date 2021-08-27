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
		int result1, result2, result3, result4;
		
		result1 = num1 + num2;
		result2 = num1 - num2;
		result3 = num1 * num2;
		result4 = num1 / num2;
		
		// * equals 사용하기
		//	조건 분기
		if(Op.equals("+")) {
			System.out.println("더한 값은 " + result1 + "입니다." );
		}
		else if(Op.equals("-")){
			System.out.println("뺀 값은 " + result2 + "입니다." );
		}
		else if(Op.equals("*")){
			System.out.println("곱한 값은 " + result3 + "입니다." );
		}
		else if(Op.equals("/")){
			System.out.println("나눈 값은 " + result4 + "입니다." );
		}	
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

}
