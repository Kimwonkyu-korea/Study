public class EX_1 {

	public static void main(String[] args) {
		String HongName = "\"홍길동\"";	// back end
		String IlName = "\"일지매\"";
		String JangName = "\"장옥정\"";    // String값으로 홍길동, 일지매, 장옥정 이름저장
		
		int HongInt = 20;                 // int형으로 나이 저장
		int IlInt = 18;
		int JangInt = 14;
		
		boolean T = true;		  // boolean형 참 거짓 판별
		boolean F = false;
		
		String HongHhone = "010-111-2222"; // 핸드폰 번호는 하이폰(-) 포함하므로 String형이다.
		String IlHhone = "02-123-4567";
		String JangHhone = "02-345-7890";
		
		double HongHei = 175.12;	   // 키는 실수이므로 double형
		double IlHei = 180.01;
		double JangHei = 155.78;
		
		String Hongadd = "\"경기도\""; 	 // 사는 지역은 문자열이므로 String형
		String Iladd = "\"서울\"";
		String Jangadd = "\"부산\"";
		
		// front end   \t로 띄어쓰기, \\로 \표시, "는 \"\"
		System.out.println("========================================================");
		System.out.println("\\ name  age     lady    phone           height  address"+"\t\\");
		System.out.println("\\========================================================");
		System.out.println("\\"+HongName+"\t"+HongInt+"\t"+T+"\t"+HongHhone+"\t"+HongHei+"\t"+Hongadd+"\t\\");
		System.out.println("\\"+IlName+"\t"+IlInt+"\t"+T+"\t"+IlHhone+"\t"+IlHei+"\t"+Iladd+"\t\\");
		System.out.println("\\"+JangName+"\t"+JangInt+"\t"+F+"\t"+JangHhone+"\t"+JangHei+"\t"+Jangadd+"\t\\");
		System.out.println("========================================================");
	
	}
	
}
