package forSample;

public class ForSum_2 {

	public static void main(String[] args) {
		
		int sum = 0;
		// 1부터 100 사이 짝수의 합
		for(int i = 2; i <= 100; i+=2) {		// 2부터 2씩 증가
			sum+=i;								// sum = sum + i
		}
		System.out.println(sum);
	}
}
