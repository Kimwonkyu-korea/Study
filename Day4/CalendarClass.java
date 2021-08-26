import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarClass {

	public static void main(String[] args) {
		
		/*
		 	Calendar, Date
		 */
		
//		Calendar cal = new GregorianCalendar();
		Calendar cal = Calendar.getInstance();
		
		//  오늘 날짜를 취득 
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;	// 0 ~ 11
		int day = cal.get(Calendar.DATE);
		
		System.out.println(year + "년 " + month + "월 " + day + "일");
		
		// 날짜 설정
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 2 -1 );
		cal.set(Calendar.DATE, 11);
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DATE);
		
		System.out.println(year + "년 " + month + "월 " + day + "일");
		
		int ampm = cal.get(Calendar.AM_PM);
		System.out.println(ampm); 	// 0: 오전, 1:오후
		
		// 요일
		int weekday =cal.get(Calendar.DAY_OF_WEEK); 	// 1(일) ~ 7(토)
		System.out.println(weekday);
		
		// 마지막날 31, 30, 28, 29
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastday);
	}

}
