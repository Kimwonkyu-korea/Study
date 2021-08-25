import java.util.Scanner;

public class Calculator_2 {

	public static void main(String[] args) {
		System.out.println("----계산기----");
		System.out.print("첫번째 숫자 입력 : ");
		Scanner scan = new Scanner(System.in); 
		int num1, num2;
		String sc;
		num1 = scan.nextInt();           // Int형 num1 입력 값
		System.out.print(" +, -, *, / 연산자를 입력해주세요:"); 
		sc = scan.next();                // String형 sc 입력 값
		System.out.print("두번째 숫자 입력 : "); 
		num2 = scan.nextInt();           // Int형 num2 입력 값

		int result1 = num1+num2;         // 더하기 값
		int result2 = num1-num2;         // 빼기 값
		int result3 = num1*num2;         // 곱하기 값
		double result4 = num1/num2;      // 나눈 값(실수형)
		
		if (sc.equals("+")) {            // sc입력 값이 + 일 때    
			System.out.println(result1);
		}
		else if(sc.equals("-")){         // sc입력 값이 - 일 때
			System.out.println(result2);
		}
		else if(sc.equals("*")){         // sc입력 값이 * 일 때
			System.out.println(result3);
		}
		else if(sc.equals("/")){         // sc입력 값이 / 일 때
			System.out.println(result4);
		}
		else 
			System.out.println("연산이 불가능합니다."); // 그 외 모든 연산처리
	}

}
