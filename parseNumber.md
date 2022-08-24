```
// tip: each public class is put in its own file
import java.util.*;
public class main
{
    private static Map<Integer, String> numMap;
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        int i = 0; 
        
        numMap = new HashMap<>();
        numMap.put(0, "영");
        numMap.put(1, "일");
        numMap.put(2, "이");
        numMap.put(3, "삼");
        numMap.put(4, "사");
        numMap.put(5, "오");
        numMap.put(6, "육");
        numMap.put(7, "칠");
        numMap.put(8, "팔");
        numMap.put(9, "구");


        for ( i=0; i < 100; i++) {
            System.out.println("{ \"cmd\": \"T\", \"recKey\": \"reckey000000028\", \"ext\": \"2855557\", \"dateTime\": \"2022-07-13 15:35:57.225322"+i+'"'+",\"dir\": \""+whoType(i)+"\", \"index\": \""+i+"\", \"stt\": \"0|1550"+i+"|s\\n1550|1600|"+parseNumber(i+1)+" 발화\\n1600|1601|s\\n\"}");
        }
    }
private static String parseNumber(int num){
         String result = "";
         String numStr = String.valueOf(num);
         int len = numStr.length();
         String first = "";
         String second = "";
         String third = "";
         switch(len){
             case 1:
                 result = numMap.get(num);
                 break;
             case 2:
                 first = numMap.get(Integer.parseInt(String.valueOf(numStr.charAt(0))));
                 second = numMap.get(Integer.parseInt(String.valueOf(numStr.charAt(1))));
                 result = (first.equals("일") ? "" : first) + "십" + (second.equals("영") ? "" : second);
                 break;
             case 3:
                 first = numMap.get(Integer.parseInt(String.valueOf(numStr.charAt(0))));
                 second = numMap.get(Integer.parseInt(String.valueOf(numStr.charAt(1))));
                 third = numMap.get(Integer.parseInt(String.valueOf(numStr.charAt(2))));
                 result = (first.equals("일") ? "" : first) + "백"
                         + (second.equals("영") ? "" : (second.equals("일") ? "" : second) + "십")
                         + (third.equals("영") ? "" : third);
                 break;
             default:
                 result = "";
         }
         return result;
     }

    private static String whoType(int num){
        int whoNum = num % 2;
        if(whoNum == 0) {
            return "T";
        } else if (whoNum == 1){
            return "R";
        } return "";
    }
}
```
