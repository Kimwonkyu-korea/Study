package forSample;

public class forClass {

	public static void main(String[] args) {
		/*
		 	loop
		 	
		 	for : 지정 회수에 따라서 반복하는 제어문
		 	
		 	형식 :
		 			for( (선언)초기화 ; 조건식 ; 연산식 ){
		 				처리 
		 			}
		 			
		 			for( (1) ; (2)(5)(8)(11) ; (4)(7)(10) ){
		 				처리 (3)(6)(9)	--> 3번
		 			}
		 		
		 			(12)
		 	
		 */
		int n;
		
		for( n = 0; n < 3; n++) {			// n이 1씩 증가
			System.out.println("for 문 ++ ");
		}
		
		for( n = 3; n > 0; n--) {			// n이 1씩 감소
			System.out.println("for 문 -- ");
		}
		
		for( n = 0; n < 10; n = n + 2 ) {	// i = 0, 2, 4, 6, 8
			System.out.println("for 문 +2 n = " + n);
		}
		
		for(int i = 0; i < 10; i++) {		// i = 0 ~ 9
			System.out.println("i = " + i);
		}
		
		for(int i = 1; i <= 10; i++) {		// i = 0 ~ 10
			System.out.println("i = " + i);
		}
		
		/* endless loop(무한 루프)
		for(int i = 0;     ; i++) {
			
		}*/
		
		int sum = 0;
		
		sum = sum + 1;
		sum = sum + 2;
		sum = sum + 3;
		sum = sum + 4;
		sum = sum + 5;
		sum = sum + 6;
		sum = sum + 7;
		sum = sum + 8;
		sum = sum + 9;
		sum = sum + 10;
				
		System.out.println(sum);
				
		sum = 0;
		
		for(int i =1; i <= 10; i++) {
			sum = sum + i;
		}
				
		System.out.println(sum);	
				
		// for 안에 for = 이중 for문	
		for(int i = 0; i < 5; i++) {		// i = 0 1 2 3 4 
			
			System.out.println("i = "+ i);
			for(int j = 0; j < 4; j++) {	// j = 0 1 2 3 
				System.out.println("\tj= "+ j);
			}
		}
				
		// for if Array
		int Array[] = { 90, 100, 55, 85, 70, 45, 80 };
		
		for(int i = 0; i < Array.length; i++) {		// for과 배열 함께 쓸 때
			if(Array[i] < 60) {
			System.out.println(Array[i]);
			}
		}
			
	}

}
