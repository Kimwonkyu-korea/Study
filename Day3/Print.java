import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Print {

	public static void main(String[] args) {
		
		// 한줄주석문 : Compile이 되지 않는 문장. 설명문
		
		/*
		 범위
		 주석문
		 */
		
		// 입력/출력
		// 외부로부터 입력(숫자, 문자열)
		// 출력(확인, 연산결과)
		
		System.out.println("Hello wolrd"); // ln == 개행

		System.out.print("Hi nice to meet you");

		System.out.println();
		
		//"Hello My World" 출력
		System.out.println("\"Hello My World\""); 
		
		// "문자열" '한' -> character
		System.out.println('한');
		
		System.out.println( 256 );
		
		System.out.println( "World" + "Hello"); // + 연산자
		
		System.out.println( 372 + "번호");
		
		System.out.println( 123 + 45 + "숫자"); // 연산 후 출력
		
		System.out.println( "숫자" + 123 + 45); // 문자열 > 숫자

		System.out.println( "숫자" + (123 + 45)); // 우선순위

		// printf           \" -> "      \n -> 개행
		System.out.printf("%c\n", 'A');
		// System.out.println();
		System.out.printf("%c %d\n", '한', 123);
		
		// string == 문자열 
		System.out.printf("%s", "안녕하세요");
		System.out.println();
		
		// 입력(console)
		Scanner scan = new Scanner(System.in); // 입력 받기 위한 절차
		
		//console 
		
		// boolean = > true / false
		// 저장공간 준비
		/*
		boolean b;
		
		System.out.print("boolean 입력 =");
		b = scan.nextBoolean();
		System.out.println(b);
		*/
	
		// integer 정수
		/*
		int num;
		
		System.out.print("숫자 입력 = ");
		num = scan.nextInt();
		System.out.println(num);
		*/
		
		// double 소수
		/*
		double d;
		System.out.print("소수 입력 = ");
		d = scan.nextDouble();
		System.out.println(d);
		*/
		// String 문자열
		// Scanner
		/*
		String str;
		
		System.out.print("문자열 입력 = ");
		str = scan.next();
		System.out.println(str);
		*/
		// BufferedReader		Buffer(저장공간)
		String str = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("str = ");
		try {
			str = br.readLine(); 	// 실제 입력 -> 띄어 쓰기가 가능하다.
		}catch (Exception e) {
		}
		
		System.out.println(str);
	}
}
