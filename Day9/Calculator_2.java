import java.util.Scanner;

public class Calculator_2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		/*
		char c = 'A';
		System.out.println( (int)c );
		
		int v = 65;
		System.out.println( (char)v );
		*/
		
		// ASCII 아스키 코드
		
		/*
		String strNum;
		System.out.print("숫자를 입력하시오.: ");
		strNum = scan.next();
		
		char c = strNum.charAt(0);
		int n = (int)c;
		if(n >= 48 && n <=57) {
			System.out.println("숫자입니다.");
		}
		else {
			System.out.println("문자입니다.");
			*/
		String strNum;
		System.out.print("숫자를 입력하시오.: ");
		strNum = scan.next();
		
		boolean b = isCharacter(strNum);
		if(b) {
			System.out.println("문자입니다.");
		}else{
			System.out.println("숫자입니다.");
		}
	}
	static boolean isCharacter(String strNum) {
		boolean b = true;
		char c = strNum.charAt(0);
		int n = (int)c;
		if(n >= 48 && n <= 57) {
			b = false;
		}
		return b;
	}
}
