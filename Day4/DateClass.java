import java.text.SimpleDateFormat;
import java.util.Date;

public class DateClass {

	public static void main(String[] args) {
		// 현재 날짜 시간 구하기
		Date today = new Date();
		System.out.println(today);


		//오늘 날짜를 yyyy-MM-dd 형태로 반환
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String result = df.format(today);
		System.out.println(result);
		
	}

}
