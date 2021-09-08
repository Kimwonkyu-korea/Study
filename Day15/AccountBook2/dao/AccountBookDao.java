package dao;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import dto.AccountBookDto;

public class AccountBookDao {
	Scanner sc = new Scanner(System.in);
	
	private List<AccountBookDto> list = new ArrayList<AccountBookDto>();
	
	public AccountBookDao() {
		list.add(new AccountBookDto(2021, 9, 2, 30000, "지출","병원","진료비 20000원 + 약 값 10000원"));
		list.add(new AccountBookDto(2021, 9, 3, 20000, "지출","치킨","허니콤보 20000원"));
		list.add(new AccountBookDto(2021, 9, 5, 250000,"수입","재난지원금","1인당 25만원 지급"));
	}
	
	// 추가
	public void Create() {
		/*System.out.print("년도를 입력하세요 = ");
		int year = sc.nextInt();
		
		System.out.print("월(달)을 입력하세요 = ");
		int month = sc.nextInt();
		
		System.out.print("일자를 입력하세요 = ");
		int date = sc.nextInt();*/
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;	// 0 ~ 11
		int date = cal.get(Calendar.DATE);
				
		
		Date today = new Date();

		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String result = df.format(today);
		System.out.println(result);
		
		System.out.print("금액을 입력하세요 = ");
		int money = sc.nextInt();
		
		System.out.print("지출/수입 중 기입하세요 = ");
		String inOut = sc.next();
		
		System.out.print("제목을 입력하세요 = ");
		String title = sc.next();

		System.out.print("내용을 입력하세요 = ");
		String content = sc.next();
		
		list.add(new AccountBookDto(year, month, date, money, inOut, title, content));
			
		System.out.println("추가 되었습니다");
	}
	
	// 삭제
	public void Delete() {	
		System.out.print("삭제할 제목을 입력 >> ");
		String title = sc.next();

		int findIndex = search(title);
		if(findIndex == -1) {
			System.out.println("삭제할 항목이 없습니다");
		}
		else {
			list.remove(findIndex);

			System.out.println("해당 가계부를 삭제했습니다");
		}
	}

	// 검색
	public void Read() {	
		System.out.println("1. 검색할 제목으로 검색 >> ");
		System.out.println("2. 검색할 날짜로 검색 >> ");
		
		System.out.println("어느 작업으로 하시겠습니까? ");
		System.out.print(">> ");
		
		int pick = sc.nextInt();

		switch(pick) {
		case 1:
			System.out.print("검색할 제목을 입력 >> ");
			String title = sc.next();
			int findIndex= search(title);
			if(findIndex == -1) {
				System.out.println("찾는 항목이 없습니다");
			}
			else {
				AccountBookDto dto = list.get(findIndex);
				System.out.println(dto.toString());
			}
			break;
		
		case 2:
			System.out.print("검색할 날짜를 입력 >> ");
			String Day = sc.next();
			
			int findIndex_1 = search2(Day);
			if(findIndex_1 == -1) {
				System.out.println("찾는 항목이 없습니다");
			}
			else {
				AccountBookDto dto = list.get(findIndex_1);
				System.out.println(dto.toString());
			}
			break;
			}
	}
		
	
	
	// 수정
	public void Update() {	
		System.out.print("수정할 제목을 입력 >> ");
		String title = sc.next();
	 
		int findIndex = search(title);
		
	
		if(findIndex == -1) {
			System.out.println("입력하신 제목이 없습니다");
		}
		else {		
			// 입력
			System.out.println("수정할 데이터를 입력해 주십시오");
			System.out.print("년도 = ");
			int year = sc.nextInt();
			
			System.out.print("월(달) = ");
			int month = sc.nextInt();
			
			System.out.print("일수 = ");
			int date = sc.nextInt();
			
			System.out.print("금액 = ");
			int money = sc.nextInt();
			
			System.out.print("수입/지출 = ");
			String inOut = sc.next();
			
			System.out.print("제목 = ");
			String Title = sc.next();
			
			System.out.print("내용 = ");
			String Content = sc.next();
						
			AccountBookDto dto = list.get(findIndex);
			
			dto.setYear(year);
			dto.setMonth(month);
			dto.setDate(date);
			dto.setMoney(money);
			dto.setInOut(inOut);
			dto.setTitle(Title);
			dto.setContent(Content);
			
			System.out.println("가계부를 수정했습니다"); 			
		}
	}
	public int search(String title) {
		int findIndex = -1;
		
		for(int i = 0;i < list.size(); i++) {
			AccountBookDto dto = list.get(i);
			
			if(title.equals(dto.getTitle())) {
				findIndex = i;
				break;
			}			
		}
		
		return findIndex;
	}	
	public int search2(String Day) {
		int findIndex_1 = -1;
		
		for(int i = 0;i < list.size(); i++) {
			AccountBookDto dto = list.get(i);
			
			if(Day.equals(dto.getDay())) {
				findIndex_1 = i;
				break;
			}			
		}
		
		return findIndex_1;
	}
	
		
		
	// 모두 출력
	public void allprint() {
		
		for (int i = 0; i < list.size(); i++) {
			AccountBookDto dto = list.get(i);
			System.out.println(dto.toString());
		}
	}
}
