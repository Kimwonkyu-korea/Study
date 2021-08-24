package if_EX;

import java.util.Scanner;

public class SuccessOrFail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정보처리기사 시험 결과");
		System.out.println("점수를 입력하시오: ");
		int score = scanner.nextInt();
		if (score >= 60)
			System.out.println("축하합니다! 합격입니다.");
	
		scanner.close();
	}

}
