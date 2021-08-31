import java.util.Scanner;

public class Calculator_1 {

	public static void main(String[] args) {
		
		// 1. 입력
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = 3;
		String numStr1;
		String Op;
		// 1.1 첫번째 숫자
//		int num1 = sc.nextInt();
		
		while(true) {
			System.out.print("첫번째 숫자를 입력하세요: ");;
			numStr1 = sc.next();
			boolean b = isNumber(numStr1);
			if(b == false) {
				System.out.println("문자가 있습니다. 다시 기입하세요.");
			}else {
				num1 = Integer.parseInt(numStr1);
				break;
			}
		}

		// 1.2 연산자 선택
		
		while(true) {
			System.out.print("연산자 +, -, *, / 중 선택하시오: ");
			Op = sc.next();
			
			if(Op.equals("+")||Op.equals("-")
					||Op.equals("*")||Op.equals("/")) {
				break;
			}
			System.out.println("연산자를 잘못 입력하셨습니다. 다시 입력하세요.");
		}
		
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
	static boolean isNumber(String str) {

		boolean b = true;

		for(int i =0; i < str.length(); i++) {
			char c = str.charAt(i);
			//			System.out.println(c);

			int asc = (int)c;
			if(asc < 48 || asc >57) {	// 48 == '0'   57 == '9'
				b = false;
				System.out.println("숫자가 아닙니다.");

				// if(c != '0' && c!= '1' && c != '2' && c != '3' && c != '4' &&)
			}
		}
		return b;
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
