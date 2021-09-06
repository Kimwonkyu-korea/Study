package cls;

public class NameCard {
	
	String name;
	String phone;
	String email;
	
	public NameCard(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}	
	
	PrintInterface PrintInterface;
	
	public void setPrintNameCard(PrintInterface p) {	
		PrintInterface = p;
	}
	public void print() {
		PrintInterface.print(this);
	}
}
