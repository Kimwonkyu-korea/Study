import java.util.Scanner;

public class SortingClass {

	public static void main(String[] args) {
		
		/*
		 	Sorting : 정렬(선택)
		 		
		 	      5 1 4 2 3
		 	오름 : 1 2 3 4 5
		 	내림 : 5 4 3 2 1
		 	
		 	swap(교환)  
		 	int num1, num2;
		 	num1 = 1;
		 	num2 = 2;
		 	
		 	int temp;
		 	temp = num1;
		 	num1 = num2;
		 	num2 = temp;
		 */
		/*
         o
         	 -   -  -  -  -  -  -  -  -
         	 o
         	     -  -  -  -  -  -  -  -
		
		int numbers[] = { 5, 1, 10, 2, 9, 3, 8, 4, 6, 7};
		int temp;
		
		for(int i = 0; i < numbers.length - 1; i++) {
			
			for(int j = i + 1; j < numbers.length; j++) {
				
				if(numbers[i] > numbers[j]) {  	// 오름
					temp = numbers[i];			// swap(교환)
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		
		for(int i = 0; i< numbers.length; i++) {
			System.out.println(numbers[i] +  " ");
		}
		*/		
		
		// sorting 				
		// 1.사용자로부터 입력
		Scanner sc = new Scanner(System.in);
		// 숫자들을 입력          : 5개의 숫자를 차례대로 입력
		System.out.print("정렬할 첫번째 숫자를 입력하시오 : ");
		int num1 = sc.nextInt();
		System.out.print("정렬할 두번째 숫자를 입력하시오 : ");
		int num2 = sc.nextInt();
		System.out.print("정렬할 세번째 숫자를 입력하시오 : ");
		int num3 = sc.nextInt();
		System.out.print("정렬할 네번째 숫자를 입력하시오 : ");
		int num4 = sc.nextInt();
		System.out.print("정렬할 다섯번째 숫자를 입력하시오 : ");
		int num5 = sc.nextInt();
		// 오름/내림             : 오름/내림 
		System.out.print("오름/내림 차순 중 선택하시오 :  ");
		String pick = sc.next();

		int number_2[] = { num1, num2, num3, num4, num5};
		int temp_2 = 0;
		// 2.정렬 처리
		if(pick.equals("오름")) {
			for(int i = 0; i < number_2.length - 1; i++) {
				
				for(int j = i + 1; j < number_2.length; j++) {
					
					if(number_2[i] > number_2[j]) {  	// 오름
						temp_2 = number_2[i];			// swap(교환)
						number_2[i] = number_2[j];
						number_2[j] = temp_2;
					}
				}
			}
			// 3.출력 처리
			for(int i = 0; i< number_2.length; i++) {
				System.out.println(number_2[i] +  " ");
			}
		}else if(pick.equals("내림")) {
			for(int i = 0; i < number_2.length - 1; i++) {
				
				for(int j = i + 1; j < number_2.length; j++) {
					
					if(number_2[i] < number_2[j]) {  	// 내림
						temp_2 = number_2[i];			// swap(교환)
						number_2[i] = number_2[j];
						number_2[j] = temp_2;
					}
				}
			}
			// 3.출력 처리
			for(int i = 0; i< number_2.length; i++) {
				System.out.println(number_2[i] +  " ");
			}
		}else
		System.out.print("잘못 입력하였습니다.  ");		
	}
}
			




