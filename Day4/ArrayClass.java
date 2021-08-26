
public class ArrayClass {

	public static void main(String[] args) {
		
		/*
		  	Array(배열) : 같은 자료형의 묶음. 변수들
		 				 목적 : 변수들을 관리하기 위함이다.
		
			int num1, num2, num3, num4, num5 ... num10;
		
			형식: 
			
				자료형 배열변수명[] = new 자료형[배열의 총 갯수];
				int Array[] = new int[10]; 
							  동적할당 : 정해지지 않는 갯수로 프로그래머가 결정해서 할당
			
				// index number : 배열변수 접근하기 위한 번호이다. 0 ~ Array.length-1
				Array[0] = 1;
				Array[1] = 2;
				Array[2] = 3;
					 :
				Array[9] = 10;	 
							  
			
		 */
//		int Array[] = new int[5];
//		int []Array = new int[5];
		int[] Array = new int[5];
		
		// 동적 : dynamic 할당 : allocation
		
		System.out.println(Array);	// heap 영역의 주소
		
		// 배열의 길이
		System.out.println(Array.length);
		
		Array[0] = 1;
		Array[1] = 2;
		Array[2] = 3;
		Array[3] = 4;
		Array[4] = 5;
		
		System.out.println(Array[2]);
		
		int Array1[];
		Array1 = new int[10];
		
		//변수의 초기화
		int num;
		num = 1;
		
		int num1 = 2;
		
		// initialize
		int Array2[] = null;	// 0000 0000
		
		// value initialize
		int Array3[] = {10, 20, 30, 40, 50, 60};
		
		int Array4[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
		
		// char 배열 "World"
		char charArray[] = new char[5];
		charArray[0] = 'W';
		charArray[1] = 'o';
		charArray[2] = 'r';
		charArray[3] = 'l';
		charArray[4] = 'd';
		
		System.out.println(charArray);
		
		char charArray1[] = { 'W', 'o', 'r', 'l', 'd' };
		
		System.out.println(charArray1);
		
		System.out.println(charArray1[0] + charArray1[1] + charArray1[2] + charArray1[3] + charArray1[4]);
		//  ASCII 아스키 코드
		System.out.println("" + charArray1[0] + charArray1[1] + charArray1[2] + charArray1[3] + charArray1[4]);
		
		// 배열 복사
		int arrayNum[] = { 11, 22, 33 };
		int arrayCopy[] = arrayNum;
		
		System.out.println(arrayNum[0]);
		System.out.println(arrayNum[1]);
		System.out.println(arrayNum[2]);
		
		System.out.println(arrayCopy[0]);
		System.out.println(arrayCopy[1]);
		System.out.println(arrayCopy[2]);
		
		arrayCopy[1] = 20;
		
		System.out.println(arrayNum[1]);
		
		int ArrayNumberPosition[] = { 1, 2, 3, 4, 5, };
		int ArrNumPos[] = ArrayNumberPosition;
		
	}

}
