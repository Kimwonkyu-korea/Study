package if_EX;

import java.util.Scanner;

public class Grading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		char grade;
		System.out.println("������ �Է��ϼ���(0~100): ");
		
		int score = scanner.nextInt(); //���� �б�
		if(score >= 90) // score�� 90�̻�
			grade = 'A';
		else if(score >= 80) // score�� 90�̻�
			grade = 'B';
		else if(score >= 70) // score�� 80�̻�
			grade = 'C';
		else if(score >= 60) // score�� 70�̻�
			grade = 'D';
		else 
			grade = 'F'; // score�� 60�̸�
		System.out.println("������" + grade + "�Դϴ�.");
		
		scanner.close();
	}
}
