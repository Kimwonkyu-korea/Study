package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {
	public static void main(String[] args) {
		/*
		  	HashMap :	사전
		  				apple -> 사과
		  				key : value
		  				tree 구조
		  				key로 관리(key 값이 중복이 되면 안된다.)
		  				 
		  	TreeMap : 	HashMap + sorting(key를 기준으로)			 
		 */
		
//		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		
		Map<Integer, String> hMap = new HashMap<Integer, String>();
		
		// 추가
		hMap.put(1, "하나");
		hMap.put(new Integer(2), "둘"); // 정석
		hMap.put(3, "셋");
		
		// 값을 산출 key -> value
		String value = hMap.get( 2 );
		System.out.println(value);
		
		// 삭제
		String del = hMap.remove( 2 );
		System.out.println(del);
		
		// 검색
		// 있다/없다 
		boolean b = hMap.containsKey( 3 );
		if(b == true) {
			String val = hMap.get(3);
			System.out.println(val);
		}
		
		
		// 수정
		hMap.replace(3, "쓰리");
		System.out.println( hMap.get( 3 ));
		
		// 추가 -> 수정이 되어 버린다.
		hMap.put(3, "삼");
		System.out.println( hMap.get( 3 ));
		
		hMap.put(4, "사");
		hMap.put(5, "오");
		
		// map에 들어 있는 모든 키와 값을 출력
		Iterator<Integer> it = hMap.keySet().iterator();
		
		while(it.hasNext()) {
			
			Integer key = it.next();
			System.out.print("key: "+ key + " ");
			
			String v = hMap.get(key);
			System.out.println("value: " + v);
		}
		
		// 좋아하는 과일 5개 
		// "apple" : "사과"
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("apple", "사과");
		map.put("banana", "바나나");
		map.put("orange", "오렌지");
		map.put("Strawberry", "딸기");
		map.put("grape", "포도");
		
		Iterator<String> it1 = map.keySet().iterator();
		
		while(it1.hasNext()) {
			
			String key = it1.next();
			System.out.print("key: "+ key + " ");
			
			String v1 = map.get(key);
			System.out.println("value: " + v1);
		}
		
		// TreeMap - sorting 필요 시
		TreeMap<String, String> tMap = new TreeMap<String, String>(map);
		
		// 오름
		//Iterator<String> itKey = tMap.keySet().iterator();
		
		// 내림
		Iterator<String> itKey = tMap.descendingKeySet().iterator();
		
		while(itKey.hasNext()) {
			String k = itKey.next();
			String v = tMap.get(k);
			
			System.out.println("key : " + k + "value : " + v);
		}
	}
}
