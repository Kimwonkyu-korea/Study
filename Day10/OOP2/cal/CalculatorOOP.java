package cal;

import java.util.Scanner;

public class CalculatorOOP {

	int num1, num2;
	String Op;
	int result;

	// 입력
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력하세요: ");
		num1 = sc.nextInt();
		
		System.out.print("연산자 +, -, *, / 중 선택하시오: ");
		Op = sc.next();
		
		System.out.print("두번째 숫자를 입력하세요: ");
		num2 = sc.nextInt(); 
	}
	// 계산
	public void calculator() {
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
	}
	// 결과출력
	public void print() {
		System.out.println(num1 + " " + Op + " " + num2 + " = " + result);
	}

}
