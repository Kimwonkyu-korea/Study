
public class WrapperClass {

	public static void main(String[] args) {
		
		/*
		  	Wrapper Class
		  	
		  	일반 자료형		Wrapper Class
		  	boolean			Boolean
		  	
		  	byte			Byte
		  	short			Short
		  	int				Integer		***
		  	long			Long
		  	
		  	float			Float
		  	double			Double		***		
		  	
		  	char			Character
		  	char[]       	String		***	// 문자열
		  		
		   
		 */
		
		// Integer == int 
		int i = 123;
		Integer iobj = 123;
		
		System.out.println(i);
		System.out.println(iobj);
		
	//	String str = new String("hello");
		String str = "hello";
		
	//  Integer obj = new Integer(123); 
		Integer obj = 123;
		
		// 숫자(Integer) -> 문자열(String)
		int number = 123; 
		String s = number + ""; 	// 문자열
		
		Integer inumber = 123; 
		String s1 = inumber.toString();
		
		// 문자열(String) -> 숫자(Integer) 중요!
		String strNum = "1024";
		int num = Integer.parseInt(strNum); 
		System.out.println(num * 2);
		
		String strNumber = "123.4567";
	//	int dnum = Integer.parseInt(strNumber);
		double dnum = Double.parseDouble(strNumber);	// 실수
		System.out.println(dnum);
		
	}

}
