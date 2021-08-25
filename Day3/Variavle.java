
public class MainClass {

	public static void main(String[] args) {
		
		/*
		  상수(숫자) : 변할 수 없는 수(지정 숫자)
		 			2진수 : 0, 1
		 			8진수 : 0 ~ 7 	8 -> 10		9 -> 011
		 			10진수 : 0 ~ 9 
		 			16진수 : 0 ~ 9 A B C D E F(15)	16 -> 0x10	15 -> 0xF
		 */
		// Variable(== 변수)
		/*
			값을 임의로 저장하기 위한 공간(메모리)
			그릇 -> 데이터
			이름을 정해 준다.
			크기 -> 데이터의 종류(정수, 실수, 문자열, 문자, 논리(true/false))
			
			자료형 변수명;		변수의 선언
			EX) int number;
			
			작명의 규칙
		*/
		
		/*
		int a; // a != A
		int A; // 대소문자를 구분한다.
		// int int; 예약어는 사용할 수 없다.
		// int 2a;	숫자가 맨 앞에 오면 안된다.
		// int 123; 상수는 사용이 안된다.
		int _abc; // 권장하지는 않는다.
		int -abc; // 연산자는 사용할 수 없다.
		
		int number_postion_char;
		int numberpostionchar; // 카멜 기법
		int numPosChr;
		
		numPosChr = 246; // 대입 연산자
		
		numPosChr = 369; // 246은 사라지고 369을 저장한다.
		*/
		
		/*
		 	변수(그릇)의 종류
		 */
		
		// 수치 
		// 정수
		byte by;	// 1 byte	256개 -> 0 ~ 255		0000 0000	0 -> +		1 -> -
					// -128 ~ 127
		by = 127;
		System.out.println(by);
		
		short sh;	// 2 byte
		sh = 12345;
		
		int i;		// 4 byte	integer
		i = 523435;
		
		long l;		// 8 byte
		l = 2458457547L;
		
		// 실수
		float f;	// 4 byte
		f =  123.4567f;
		
		double d;	// 8 byte
		d = 234.5678912345;
		
		// 문자
		// 한문자
		char c;		// 2 byte	character
		
		c = 'A';
		c = 'a';
		c = '한';
		// c = 'ab'; 	문자열
		
		// 문자열(String) == object
		String str = "문자들";
		str = "문자열";
		System.out.println(str);
		
		// 논리		참(true)/거짓(false)
		boolean b; 	// 1 byte
		b = false;	// 숫자는 에러
		b = true;
		System.out.println(b);
		
		// escape sequence
		// \n(개행), \"(따옴표), \', \t(띄어쓰기), \\
		
		System.out.println("\\");
	}

}
