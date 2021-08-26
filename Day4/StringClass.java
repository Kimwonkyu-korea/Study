
public class StringClass {

	public static void main(String[] args) {
		/*
		 	String : wrapper class
		 	문자열 
		 	
		 	char c = '하';
		 	char arrChar[] = { '안', '녕'};
		 */
		String str; 			// int n;
		// String : class명
		// str : 변수
		
		str = "안녕하세요";
		System.out.println(str);
		
		String str1 = new String("반갑습니다");
		
		String str2 = str + str1;
		System.out.println(str2);
		
		str2 = str2 + "건강하세요";
		System.out.println(str2);
		
		/*
		 		나오는 값 = 함수명( 들어오는 값 );
		 		나오는 값 = 함수명( 들어오는 값1, 들어가는 값2 );
		  		나오는 값 = 함수명( 들어오는 값1, 들어가는 값2, 들어가는 값3);
		 */
		// 비교함수
		// equals
		String str3 = "world";
		String str4 = "worl";

		str4 = str4 +"d";
		System.out.println( str4 );
		System.out.println( str3 == str4 );
		
		boolean b = str3.equals(str4);
		System.out.println(b);
		
		System.out.println(str3.equals(str4));
		
		// 문자의 위치 탐색
		// indexOf			int arrat[] = new int[5];		array[0] ~ [4]
		// lastIndexOf
		String str5 = "abcdeabcde";
		int index = str5.indexOf("c");
		System.out.println(index);
		
		int lastIndex = str5.lastIndexOf("c");
		System.out.println(lastIndex);
		
		// 문자의 길이
		// length 
		// array.length
		int len = str5.length();
		System.out.println(len);
		
		// 수정
		// replace
		String str6 = "A*B*C*D";
		String reStr = str6.replace("*","-");
		System.out.println(reStr);
				
		String dateStr ="2021-08-26"; // 20210826
		dateStr = dateStr.replace("-", "");
		System.out.println(dateStr);
		
		// 문자열 자른다.	홍길동-24-2000/02/17-서울시	'-' == token
		/*
		  	홍길동
		  	24
		  	2000/02/27
		  	서울시
		  	
		  	split
		 */
		String str7 = "홍길동-24-2000/02/17-서울시";
		
		String split[] = str7.split("-");
		System.out.println(split.length);

		System.out.println(split[0]);
		System.out.println(split[1]);
		System.out.println(split[2]);ㅁ
		System.out.println(split[3]);
		
		// 문자열을 자른다.
		// 범위를 설정해서 자른다.
		// 홍길동-24-2000/02/17-서울시
		// substring
		String  str8 = "홍길동-24-2000/02/17-서울시";
		String name = str8.substring(0, 3);		//  시작위치, 이 위치 전까지
		System.out.println(name);
		
		String human = str8.substring(4);		//  시작위치 ~ 끝까지
		System.out.println(human);
		
		String str9 = "abcDEF";
		
		// 문자열 --> 대문자
		String upStr = str9.toUpperCase();
		System.out.println(upStr);
		
		// 문자열 --> 소문자
		String lowStr = str9.toLowerCase();
		System.out.println(lowStr);
		
		// 문자열의 앞뒤의 공백을 제거
		// trim
		String str10 = "  java java   java          ";
		String trimStr = str10.trim();
		System.out.println(trimStr);

		// 배열처럼 사용할 수 있는 함수	0 ~ n-1
		// charAt
		String str11 = "가나다라마";
		char c = str11.charAt(0);	// str11[0]
		System.out.println(c);
		
		// 문자열 탐색
		// contains
		String str12 = "서울시 강남구";
		boolean b1 = str12.contains("마포");
		
		System.out.println(b1);
	}

}
