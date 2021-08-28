package forSample;

public class ForSum_1 {

	public static void main(String[] args) {
		
		int sum = 0;
		// 1부터 100까지 사이 홀수의 합
		for(int i = 1; i <= 100; i+=2) {	// 1부터 2씩 증가
			sum+=i;							// sum = sum + i
		}
		System.out.println(sum);
	}
}
