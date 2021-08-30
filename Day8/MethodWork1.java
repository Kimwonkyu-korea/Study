import java.util.Arrays;

public class MethodWork1 {

	public static void main(String[] args) {
		/*
		  	int num1[] = {1, 2, 3, 4, 5};
		  	배열의 값에 *2배의 연산된 값이 산출되도록 메소드를 작성하시오.



		 */

		int num1[] = {1, 2, 3, 4, 5};
		
		num1 =	numberDouble(num1);
		
		for(int i : num1) {
			System.out.print(i+ " ");
		}
		System.out.println();
		
		System.out.println( Arrays.toString(num1)) ;
	}
	static int[] numberDouble(int num1[]) {

		for (int  i= 0; i < num1.length; i++) {
			num1[i] = num1[i] * 2;
		}
		return num1;
	}

}
