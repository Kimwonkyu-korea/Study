import java.util.Scanner;

public class Calculator_1 {

	public static void main(String[] args) {
		System.out.println("----계산기----");
		System.out.print("첫번째 숫자 입력 : ");
		Scanner scan = new Scanner(System.in);  // Scanner를 통해 입력 값 받기
		int num1, num2;
		num1 = scan.nextInt(); // Int형 num1 입력 값
		System.out.print("두번째 숫자 입력 : ");
		num2 = scan.nextInt(); // Int형 num2 입력 값
		
		int result1 = num1+num2; // 더하기 값
		int result2 = num1-num2; // 빼기 값
		int result3 = num1*num2; // 곱한 값
		double result4 = num1/num2; // 나눈 값(실수형)
		
		System.out.println("더하기 연산자는: " + result1); 
		System.out.println("빼기 연산자는: " + result2);
		System.out.println("곱하기 연산자는: " + result3);
		System.out.println("나누기 연산자는: " + result4);


	}

}
