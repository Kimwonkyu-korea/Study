package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	ArrayList : 검색
		 	
		 	LinkedList : 실시간 추가, 삭제의 처리가 빠르다.
		 */
		
		ArrayList<String> alist = new ArrayList<String>();
		
		alist.add("tigers");
		
		String str = new String("lions");
		alist.add(str);
		
		alist.add("giants");
		
		LinkedList<String> list = new LinkedList<String>(alist);
		/*
		for(String s : list) {
			System.out.println(s);
		}
		*/
		list.add("twins");
		
		// 맨 앞에 object를 추가
		list.addFirst("bears");	// LinkedList
		/*
		for(String s : list) {
			System.out.println(s);
		}*/
		// 맨 뒤에 object를 추가
		list.addLast("kings");
		/*
		for(String s : list) {
			System.out.println(s);
		}*/
		
		// iterator : 반복자 == pointer
		Iterator<String> it;
		it = list.iterator();
		
		while(it.hasNext()) {
			String value = it.next();
			System.out.println(value);
		}
	}
}
