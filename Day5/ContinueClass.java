package continueSample;

import java.util.Scanner;

public class ContinueClass {

	public static void main(String[] args) {
		
		/*
		 	continue : loop문 같이 사용
		 			 : skip(생략)
		 			 
		 	while(조건문){
		 	
		 		처리 1
		 		
		 		처리 2
		 		
		 		if(조건){
		 			continue;
		 		}
		 		
		 		처리 3		---> 처리가 생략
		 	
		 	}
		 */
		/*
		int w;
		
		w = 0;
		while( w < 5) {
			
			System.out.println("w = "+ w);
			
			if(w == 3) {
				continue;
			}
			
			w++;
		}
		
		
		for(int i = 0; i < 10; i++) {
			System.out.println("i = "+ i);
			
			System.out.println("for start");
			
			if(i > 5) {
				continue;
			}
			
			System.out.println("for end");
		}
		*/
		// 숫자 입력 5개
		// 조건: 음수를 입력받으면 안된다.
		Scanner sc = new Scanner(System.in);
		
		int number;
		int loop = 0;
		
		while(loop < 5) {
			System.out.print((loop + 1) + "번째 수 = ");
			
			number = sc.nextInt();
			
			if(number < 0) {
				System.out.println("음수를 입력하셨습니다. 다시 입력해 주세요");
				continue;
			}
			
			loop++;
		}
		
	}

}
