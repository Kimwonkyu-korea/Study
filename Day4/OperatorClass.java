
public class OperatorClass {

	public static void main(String[] args) {

		/*
		 	Operator : 연산자
		  
		  	+ - * / %
		  	
		  	9 / 2 -> 4 몫
		  	9 % 2 -> 1 나머지		  	
		  	
		 */
		int num1, num2;
		int result; 
		
		// 입력
		num1 = 25;
		num2 = 7;
		
		// 연산 처리
		result = num1 + num2;
		
		System.out.println(result);
		System.out.println(num1 + " + " + num2 + " = " + result);
		
		result = num1 - num2;
		System.out.println(num1 + " - " + num2 + " = " + result);
		
		result = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + result);
		
		result = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + result);

		result = num1 % num2;
		System.out.println(num1 + " % " + num2 + " = " + result);
		
		// 자기(변수) 자신의 값을 변경
		int num3 = 0;
		
		num3 = num3 + 3;
		System.out.println("num3 = " + num3);
		
		num3 += 4; // num3 + 4 = num3
		System.out.println("num3 = " + num3);
		
		// increment(증가), decrement(감소)
		// ++ 				--
		
		int num4 = 0;
		
		num4++; 		// num4 = num4 + 1 , num4 += 1
		System.out.println("num4 = " + num4);
		
		++num4;
		System.out.println("num4 = " + num4);
		
		
		num4--;		// num4 = num4 - 1 , num4 -= 1
		System.out.println("num4 = " + num4);
		
		--num4;
		System.out.println("num4 = " + num4);
		
		
		int num5, num6;
		
		num5 = 1;
		
		num6 = num5++;
		// num6 = ++num5
		
		// numt5++;
		// num6 = num5;
		System.out.println("num5 = " + num5); 
		System.out.println("num6 = " + num6); 
		
		// 연산중에 주의해야 될 연산
		// /, %  - > 분모가 0이면 안된다.	
	}

}
