import java.util.Scanner;

public class SortingReFac {

   public static void main(String[] args) {
      
      // sorting
      Scanner sc = new Scanner(System.in);
      
      // 변수들
      int numbers[] = null;
      int count;
      String updown;
      String again;
      
      while(true) {
         //초기화
         count = 0;
         updown = "오름";
         
         // 1.사용자로부터 입력
              // 정렬할 숫자들의 갯수     : 5
         System.out.print("정렬할 수의 총수 = ");
         count = sc.nextInt();
              // 정렬할 수만큼 배열을 할당 : 배열을 5
         numbers = new int[count];
              // 숫자들을 입력          : 5개의 숫자를 차례대로 입력
         for(int i = 0; i < numbers.length; i++) {
            System.out.print( (i + 1) + "번째 수 = ");
            numbers[i] = sc.nextInt();
         }
              // 오름/내림             : 오름/내림     
         System.out.print("오름/내림 = ");
         updown = sc.next();
         
         // 2.정렬 처리
         int temp;
         
         for(int i = 0; i < numbers.length - 1; i++) {
            
            for(int j = i + 1; j < numbers.length; j++) {
               
               if(updown.equals("오름")) {
                  if(numbers[i] > numbers[j]) {
                     temp = numbers[i];
                     numbers[i] = numbers[j];
                     numbers[j] = temp;
                  }
               }
               else if(updown.equals("내림")) {
                  if(numbers[i] < numbers[j]) {
                     temp = numbers[i];
                     numbers[i] = numbers[j];
                     numbers[j] = temp;
                  }
               }
            }
         }
            // 오름/내림
         // 3.출력 처리
         for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
         }
         System.out.println();
         
         System.out.print("다시 시작하시겠습니까?(y/n) = ");
         again = sc.next();
         
         if(again.equals("n")) {
            System.out.println("안녕히 가십시오");
            break;
         }
         System.out.println("다시 시작합니다 >>");
      }
   }

}