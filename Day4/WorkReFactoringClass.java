import java.util.Scanner;

public class WorkReFactoringClas{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
		int price;
		int myMoney;
		int changeMoney;
		
		System.out.print("지불할 금액을 입력하세요 :");
		myMoney = scan.nextInt();
		
		System.out.print("거스름 돈을 입력하세요 :");
		price = scan.nextInt();
		changeMoney = myMoney - price;
		
		
		//5000원
		int m5000 = changeMoney /  5000; // 6790 /5000
		                         
		//1000원                 
		int m1000 = (changeMoney %  5000) / 1000; 
		                         
		//500원                  
		int m500 = (changeMoney %  1000) / 500; 
		                         
		//100원                  
		int m100 = (changeMoney %  500) / 100;
		                         
		//50원                   
		int m50 = (changeMoney % 100) / 50; 
		        
		//10원
		int m10 = (changeMoney % 50) / 10;
		
		System.out.println("5000원 -> "+ m5000 + "개 입니다");
		System.out.println("1000원 -> " + m1000+ "개 입니다");
		System.out.println("500원 -> " +  m500+ "개 입니다");
		System.out.println("100원 -> " + m100+ "개 입니다");
		System.out.println("50원 -> " + m50+ "개 입니다");
		System.out.println("10원 -> " + m10+ "개 입니다");
		
	}

}
