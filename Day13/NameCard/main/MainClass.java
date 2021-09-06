package main;

import cls.NameCard;
import cls.PrintNameCard;
import cls.printPhoneCard;

public class MainClass {

	public static void main(String[] args) {

		NameCard ncard = new NameCard("홍길동", "123-4567", "hgd@naver.com");
		
		ncard.setPrintNameCard(new PrintNameCard());
		ncard.print();
		
		ncard.setPrintPhoneCard(new printPhoneCard());
		ncard.phoneprint();
	}

}
