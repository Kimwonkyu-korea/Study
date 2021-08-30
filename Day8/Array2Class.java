import java.util.Iterator;

public class Array2Class {

	public static void main(String[] args) {
		/*
		 	Array : 같은 자료형 변수들의 묶음.
		 			관리(접근)는 index number로 관리된다.
		 			
		 	int array[] = new int[10];
		 	array[0] = 10;
		 	
		 	int array[] = { 1, 2, 3};	선언과 동시에 초기화
		 	
		 	2차원 배열
		 	
		 	int array2[][] = new int[3][4];
		 	
		 	int array2[][] = {
		 		{ 1, 2, 3, 4},
		 		{ 5, 6, 7, 8},
		 		{ 9, 10, 11, 12}
		 	};
		 */
		
		int array2[][] = new int[3][4];
		
		array2[0][0] = 1;
		array2[0][1] = 2;
		array2[0][2] = 3;
		array2[0][3] = 4;
		
		array2[1][0] = 5;
		array2[1][1] = 6;
		array2[1][2] = 7;
		array2[1][3] = 8;
		
		array2[2][0] = 9;
		array2[2][1] = 10;
		array2[2][2] = 11;
		array2[2][3] = 12;
		
		for(int i=0; i < array2.length; i++) {
			for(int j = 0; j < array2[i].length; j++) {
				System.out.print(array2[i][j] + " ");
			}
			System.out.println();
		}
		// 초기화
		char cArray[][] = {		// = new int [2][5];
				{ 'H', 'e', 'l', 'l', 'o' },
				{ 'W', 'o', 'r', 'l', 'd' },
		};

		System.out.println(cArray[1][2]);
		
		String strArr[][] = {
				{ "홍길동", "90" },
				{ "성춘향", "100" },
				{ "정수동", "85" },
		};
		
		int sum = 0;
		
		for (int i = 0; i < strArr.length; i++) {
			sum += Integer.parseInt(strArr[i][1]);	// String -> int 변환
		}
		System.out.println("합계 : " + sum);
		
	}
}
