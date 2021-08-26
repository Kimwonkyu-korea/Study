import java.util.Scanner;

public class Work1_Class {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("총 금액은 3.210원 입니다.");
		System.out.print("지불할 금액을 입력하세요 :");
		
		int num1, num2;
		
		num1 = 3210;
		num2 = scan.nextInt();
		num2 = num2 - num1;
		
		
		System.out.println("거스름 돈은 " + num2 + "입니다.");
		System.out.println();
		
		int num3, num4, num5, num6, num7, num8;
		int num3_1, num4_1, num5_1, num6_1, num7_1, num8_1;
		
		num3 = num2 / 5000; // 6790 / 5000 = 1
		num3_1 = num2 % 5000;  // 1790
		System.out.println("5000원 -> " + num3 + "개 입니다.");
		num4 = num3_1 / 1000;
		num4_1 = num3_1 % 1000; // 1790 % 1000 = 790
		
		System.out.println("1000원 -> " + num4 + "개 입니다.");
		num5 = num4_1 / 500;
		num5_1 = num4_1 % 500;
		
		System.out.println("500원 -> " + num5 + "개 입니다.");
		num6 = num5_1 / 100;
		num6_1 = num5_1 % 100;
		
		System.out.println("100원 -> " + num6 + "개 입니다.");
		num7 = num6_1 / 50;
		num7_1 = num6_1 % 50;
		
		System.out.println("50원 -> " + num7 + "개 입니다.");
		num8 = num7_1 / 10;
		num8_1 = num7_1 % 10;
	
		System.out.println("10원 -> " + num8 + "개 입니다.");
	
	}

}
