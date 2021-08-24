public class DoWhileSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c ='a';
		
		do {
			System.out.print(c);
			c= (char)(c+1); // 영문의 경우 1을 더하면 다음 문자의 코드 값 호출
		}while(c<='z');
	}
}
