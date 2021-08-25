import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("----계산기----");
		System.out.print("첫번째 숫자 입력 : ");
		Scanner scan = new Scanner(System.in); 
		int num1, num2;
		num1 = scan.nextInt();
		System.out.print("두번째 숫자 입력 : ");
		num2 = scan.nextInt();
		
		int result1 = num1+num2;
		int result2 = num1-num2;
		int result3 = num1*num2;
		double result4 = num1/num2;
		
		System.out.println("더하기 연산자는: " + result1);
		System.out.println("빼기 연산자는: " + result2);
		System.out.println("곱하기 연산자는: " + result3);
		System.out.println("나누기 연산자는: " + result4);


	}

}
