package main;

import java.util.ArrayList;
import java.util.List;

import dto.MyClass;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	Collection(수집)
		 	
		 	List :	목록
		 	
		 		ArrayList
		 			배열처럼 사용할 수 있는 목록
		 			선형구조					data-data-data-data
		 			장점 : 검색속도가 빠르다. 효율적이다.		- 관리
		 			
		 		LinkedList
		 			장점 : 추가/삭제 속도가 빠르다.	 		- 게임
		 			
		 	Map	: 
		 		
		 		HashMap
		 		
		 		TreeMap
		  
		 */
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// CRUD
		// 추가
		Integer iobj = new Integer(111);
		list.add(iobj);		// 정석
		
		list.add(222);
		
		list.add(new Integer(333));
		
		int len = list.size();
		System.out.println("len :" + len);
		/*
		for(int i = 0; i < list.size(); i++) {
			Integer in = list.get(i);
			System.out.println(in);
		}
		
		for(Integer in : list) {
			System.out.println(in);
		}
		*/
		// list[1] == list.get(1)
	//	System.out.println("list.get(1) : " + list.get(1));
		
		// 원하는 곳에 추가
		Integer inum = 200;
		list.add(1, inum);
		for(Integer in : list) {
			System.out.println(in);
		}
		
		// 검색
		int index = list.indexOf( 222 );
		System.out.println("index: " + index);
		
		for(int i = 0; i < list.size(); i++) {
			Integer in = list.get(i);
			if(in == 200) {
				System.out.println("index: " + i);
			}
		}
		
		// 수정
		Integer newdata = new Integer(300);
		list.set(3, newdata);
		
		for(Integer in : list) {
			System.out.println(in);
		}
		
		// 삭제
		list.remove(1);
		for(Integer in : list) {
			System.out.println(in);
		}
		
		// ArrayList<String> 
		// 추가(끝, 중간), 삭제, 검색, 수정
		
//		ArrayList<MyClass> mlist = new ArrayList<MyClass>();

		List<MyClass> mlist = new ArrayList<MyClass>();
		
		// 추가
		MyClass mycls = new MyClass(1, "성춘향", 165.1);
		mlist.add(mycls);
		
		mlist.add(new MyClass(2, "이몽룡", 172.3));
		
		mycls = new MyClass(3, "향단이", 168.5);
		mlist.add(mycls);
		
		mlist.add(2, new MyClass(4, "월매", 166.8));
		
		for(int i = 0; i <mlist.size(); i++) {
//			MyClass my = mlist.get(i);
//			System.out.println(my.toString());
			
			System.out.println(mlist.get(i).toString());
		}
		// 삭제
		mlist.remove(2);
		
		for (MyClass my : mlist) {
			System.out.println(my.toString());
		}
		
		// 검색
		String name = "이몽룡";
		int _index = -1;
		for(int i = 0; i < mlist.size(); i++) {
			MyClass my = mlist.get(i);
			if(name.equals(my.getName())) {
				_index = i;
				break;
			}
		}
		//System.out.println(mlist.get(_index).toString());
		
		// 수정
		MyClass newObj = new MyClass();
		newObj.setNumber(22);
		newObj.setName("LMR");
		newObj.setHeight(175.9);
		
		mlist.set(1, newObj);
		
		for (MyClass my : mlist) {
			System.out.println(my.toString());
		}
	}
}