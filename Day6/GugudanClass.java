package forSample;

public class GugudanClass {

	public static void main(String[] args) {
		
		for(int i = 2; i <= 9; i++) {			// i는 2단부터 9단까지 
			System.out.println("구구단 "+ i +"단");
			for(int j = 1; j <=9; j++ ) {		// j는 i로부터 1 ~ 9까지 곱하기 값
				System.out.println("\t " +i+ "*" + j + "=" + i*j);	// \t 가독성, 단(i) * 곱한 값(j) =  결과 값(i*j)
			}
		}
	}
}
