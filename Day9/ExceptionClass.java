
public class ExceptionClass {

	public static void main(String[] args) {
		/*
		 	Exception : 예외 != 에러
		 	
		 	1 ~ 10 -> 'A'
		 	정수 -> 'A' == 65
		 	
		 	- 자주 발생
		 	number 	형식 위반
		 	array  	범위 초과		int arr[] = new int[3];		arr[3] = 12;
		 	class	없는 class
		 	file	파일 없음	
		 	
		 	형식 : 
		 		try {
		 		
		 			// 예외가 발생될 수 있는 코드
		 			
		 			 
		 		}catch(예외 클래스1 e){
		 			예외1 메시지를 출력
		 		}catch(예외 클래스1 e){
		 			예외2 메시지를 출력
		 		}catch(예외 클래스1 e){
		 			예외3 메시지를 출력
		 		}finally{
		 			무조건 실행 !
		 			rollback(복구) - undo
		 		}
		 		// 예외 클래스 한정이 없음
		 		 
		 		static void method() throws 예외 클래스 {
		 			예외가 발생될 소지가 있음
		 		}
		 
		int array[] = { 1, 2, 3 };
		
		System.out.println("start");
		
		try {
			for(int i = 0; i < 4; i++) {
				System.out.println(array[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			// System.out.println("배열범위 초과");
			// e.printStackTrace();
			System.out.println(e.getMessage());
			
			//return;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally 부분");
		}
		
		System.out.println("end");
		*/
		method();
	}
	
	static void method() throws IndexOutOfBoundsException {
		
		int array[] = { 1, 2, 3 };
		
		for(int i = 0; i < 4; i++) {
			System.out.println(array[i]);
		}
	}

}
