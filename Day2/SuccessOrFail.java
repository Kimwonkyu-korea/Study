package if_EX;

import java.util.Scanner;

public class SuccessOrFail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("����ó����� ���� ���");
		System.out.println("������ �Է��Ͻÿ�: ");
		int score = scanner.nextInt();
		if (score >= 60)
			System.out.println("�����մϴ�! �հ��Դϴ�.");
	
		scanner.close();
	}

}
