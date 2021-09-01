package main;

import sub.subStudent;

public class MainStudent {

	public static void main(String[] args) {
		
		subStudent s = new subStudent();
		
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math =76;
		
		System.out.println("이름 : " + s.name + "\t" + "반 : " + s.ban + "\t" + "번호 : " + s.no);
		System.out.println("총점 : " + s.getTotal(s.kor,s.eng,s.math));
		System.out.println("평균 : " + s.getAverage());
		
	}

}
