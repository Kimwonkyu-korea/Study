
public class SumClass {

	public static void main(String[] args) {
		
		// 1 ~ 100 사이에 짝수의 합과 홀수의 합을 각각 출력
		int sum1, sum2;
		sum1 = sum2 = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 1) {		// 홀수
				sum1 += i; // sum1 = sum1 + i
			}
			else if(i % 2 ==0) {	// 짝수	
				sum2 = sum2 + i;	//sum2 = sum2 + i
			}
		}
		System.out.println("홀수의 합 : " + sum1);	
		System.out.println("짝수의 합 : " + sum2);	
	}
}
