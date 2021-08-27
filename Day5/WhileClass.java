package whileSample;

public class WhileClass {

	public static void main(String[] args) {
		
		/*
		 	loop
		 	
		 	for(초기화 ; 조건식 ; 연산식){
		 		처리
		 	}
		 	
		 	초기화
		 	while(조건식){		if(조건식){
		 		처리					처리
		 		연산식			}
		 	}	
		 */
		
		int w;
		
		w = 0;
		while(w < 5) {
			System.out.println("while loop w = " + w);
			w++;			
		}
		/*
		 	형식 :
		 		초기화
		 		
		 		do {
		 			처리
		 			연산식
		 		}while(조건식);
		 
		 */
		int dw;
		dw = 0;
		
		do {
			System.out.println("do while loop");
			
			dw++;
		}while(dw < 5);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
