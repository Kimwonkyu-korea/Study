import java.util.Scanner;

public class SubClass {

	public static void main(String[] args) {
		System.out.println("----계산기----");
		System.out.print("첫번째 숫자 입력 : ");
		Scanner scan = new Scanner(System.in); 
		int num1, num2;
		String sc;
		num1 = scan.nextInt();
		System.out.print(" +, -, *, / 연산자를 입력해주세요:");
		sc = scan.next();
		System.out.print("두번째 숫자 입력 : ");
		num2 = scan.nextInt();

		int result1 = num1+num2;
		int result2 = num1-num2;
		int result3 = num1*num2;
		double result4 = num1/num2;
		
		if (sc.equals("+")) {
			System.out.println(result1);
		}
		else if(sc.equals("-")){
			System.out.println(result2);
		}
		else if(sc.equals("*")){
			System.out.println(result3);
		}
		else if(sc.equals("/")){
			System.out.println(result4);
		}
		else 
			System.out.println("연산이 불가능합니다.");
	}

}
