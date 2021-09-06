package main;

import cls.NameCard;
import cls.PrinNameCard;
import cls.PrintInterface;
import cls.PrintPhoneCard;

public class MainClass {
	public static void main(String[] args) {
		
		NameCard nc = new NameCard("성춘향", "234-5678", "sch@daum.net");
		
		PrintInterface p = new PrinNameCard();
		p.print(nc);
		

		PrintInterface p1 = new PrintPhoneCard();
		p1.print(nc);
		
		/*
		nc.setPrintNameCard(new PrinNameCard());
		nc.print();
		
		nc.setPrintNameCard(new PrintPhoneCard());
		nc.print();
		*/
	}

}
