package if_EX;

import java.util.Scanner;

public class Grading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		char grade;
		System.out.println("점수를 입력하세요(0~100): ");
		
		int score = scanner.nextInt(); //점수 읽기
		if(score >= 90) // score가 90이상
			grade = 'A';
		else if(score >= 80) // score가 90이상
			grade = 'B';
		else if(score >= 70) // score가 80이상
			grade = 'C';
		else if(score >= 60) // score가 70이상
			grade = 'D';
		else 
			grade = 'F'; // score가 60미만
		System.out.println("학점은" + grade + "입니다.");
		
		scanner.close();
	}
}
