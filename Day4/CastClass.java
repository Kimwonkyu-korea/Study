
public class CastClass {

	public static void main(String[] args) {
		
		/*
		 	우선 순위		바이트
		 낮음	
		 	boolean     1 byte		그릇의 사이즈가 작다.
		 	
		 	byte		1 byte
		 	short		2
		 	int			4
		 	long		8
		 	
		 	float		4
		 	double		8			그릇의 사이즈가 크다
		 높음	
		 	변환 
		 	자동 (자료)형 변환
		 	강제 (자료)형 변환 - Cast
		 */
		
		// 자동 형변환
		short sh = 12345;
		int num;
		
		num = sh;	// 자동 형변환
		System.out.println(num);
		
		double d;
		
		d = num;	// 자동 형변환
		System.out.println(d);
		// 강제 (자료)형 변환 - Cast
		int number = 256;
		short sho;
		
		sho = (short)number;
		System.out.println(sho);
		
		float f;
		
		f = (float)3 / 2;
		System.out.println(f);
		
		
		
		
	}

}
