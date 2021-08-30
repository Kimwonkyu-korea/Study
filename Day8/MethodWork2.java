import java.util.Arrays;

public class MethodWork2 {

	public static void main(String[] args) {
		/*
		 	int[] original = {1,2,3,4,5,6,7,8,9 };
		 	주어진 배열에 담긴 값의 위치를 바꾸는 작업을 반복하여 뒤섞이게 한다.
		 	int[] result = shuffle(orginal);
		 */
		
		int original[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		original = shuffle(original);
		System.out.println( Arrays.toString(original));
		
	//	int r = (int)(Math.random()* 10); // 0 1 2
	//	System.out.println("r = "+ r);
	}
	/*
	static int[] shuffle(int original[]) {
		
	}*/
	static int[] shuffle(int original[]) {
		
		for(int i = 0; i < 1000; i++) {	// 섞는 횟수
	
	
		int x = (int)(Math.random()* 9 ); // 0~ 8
		int y = (int)(Math.random()* 9 ); // 0~ 8
		
		int temp = original[x];			// 0 1 2 3 4 5 6 7 8 
		original[x]  = original[y];
		original[y] = temp;
		}
		
		return original;
	}
}