package cls;

public class NameCard {
	String name;
	String phone;
	String email;
	
	PrintNameCard printNameCard;
	
	public NameCard(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public void setPrintNameCard(PrintNameCard p) {
		printNameCard = p;
	}
	
	public void print() {
		printNameCard.print(this);
	}
	
	printPhoneCard printPhoneCard;
	
	public void setPrintPhoneCard(printPhoneCard p) {
		printPhoneCard = p;
	}
	
	public void phoneprint() {
		printPhoneCard.print(this);
	}
}
