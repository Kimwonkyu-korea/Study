package dto;

public class AccountBookDto {
	private int year;
	private int month;
	private int date;
	private int money;
	private String inOut;
	private String title;
	private String content;
	private String Day;
	
	public String getDay() {
		this.Day = year+"/"+month+"/"+date;;
		return Day;
	}
	public void setDay(String day) {
		this.Day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getInOut() {
		return inOut;
	}
	public void setInOut(String inOut) {
		this.inOut = inOut;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public AccountBookDto( int year,int month, int date,  int money, String inOut, String title, String content) {
		super();
		this.year = year;
		this.month = month;
		this.date = date;
		this.money = money;
		this.inOut = inOut;
		this.title = title;
		this.content = content;
		
	}
	
	
	@Override
	public String toString() {
		return "가계부 [" + year + "/" +  month + "/" +  date + " " + money + "원 "   + inOut + "  " + title  +"  "+ content +" ]";
	}
}
