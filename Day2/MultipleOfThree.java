package if_EX;

import java.util.Scanner;

public class MultipleOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("����ó����� ���� ���");
		System.out.println("������ �Է��Ͻÿ�: ");
		int score = scanner.nextInt();
		if (score >= 60)
			System.out.println("�����մϴ�! �հ��Դϴ�.");
		else
			System.out.println("���հ��Դϴ�.");
		scanner.close();
	}

}
