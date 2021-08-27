package breakSample;

public class breakClass {

	public static void main(String[] args) {
		
		/*
		  	break	== 탈출(loop문)
		  	
		  	for, while, do-while
		  	
		  	형식:
		  		for(int i = 0; i < 10; i++){
		  			if(조건){
		  				break;
		  			}
		  		}
		 */
		
		for(int i = 0; i < 10; i++) {
			System.out.println("for loop i = " + i);
			
			if(i == 5) {			// 5가 나오면 탈출
				break;
			}
		}
		System.out.println("탈출");
		
		char cArray[] = { 'a', 'b', 'c', 'd'};
		
		for(int i = 0; i < cArray.length; i++) {
			System.out.println("i = " + i);
			if(cArray[i] == 'c') {
				System.out.println("c를 찾았습니다.");
				break;
			}
		}
		
		// foreach
		/*
		  	for(초기화 ; 조건식 ; 연산식){
		  		처리
		  	}
		  
		 	for(자료형 변수 : 배열(리스트)){
		 		처리
		 	}
		 */
		
		int array[] = { 11, 22, 33 ,44 ,55 };
		/*
		for(int i =0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		 */
		/*
		for(int num : array) {
			System.out.println(num);
		}
		*/
		/*
		for(int i =0; i < array.length; i++) {
			System.out.println(array[i]);
			if(array[i] == 33) {
				break;
			}
		}
		*/
		for(int num : array) {
			System.out.println(num);
			if(num == 22) {
				break;
			}
		}
		
		
	}
}
