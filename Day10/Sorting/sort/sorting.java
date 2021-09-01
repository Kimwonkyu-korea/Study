package sort;

import java.util.Scanner;

public class sorting {
   
   private int number[];
   private String updown;
   
   
   // 1. 입력
   public void input() {
      Scanner sc = new Scanner(System.in);
      
      // 입력하는 수의 개수
      System.out.print("정렬할 수의 총수 = ");
      int count = sc.nextInt();
      
      // 배열의 할당
      number = new int[count];
      // 숫자들을 입력
      for(int i = 0; i < number.length; i++) {
         System.out.print( (i + 1) + "번째 수 = ");
         number[i] = sc.nextInt();
      }
      // 오름/내림 고르기
      System.out.print("오름/내림 = ");
      updown = sc.next();
   }
   // 2. 정렬
   public void sorting() {
      int temp;
      
      for(int i = 0; i < number.length - 1; i++) {
         
         for(int j = i + 1; j < number.length; j++) {
            
            if(updown.equals("오름")) {
               if(number[i] > number[j]) {
                  temp = number[i];
                  number[i] = number[j];
                  number[j] = temp;
               }
            }
            else if(updown.equals("내림")) {
               if(number[i] < number[j]) {
                  temp = number[i];
                  number[i] = number[j];
                  number[j] = temp;
               }
            }
         }
      }
   }
   // 3. 출력
   public void print() {
      for(int i = 0; i < number.length; i++) {
         System.out.print(number[i] + " ");
      }
   }

}