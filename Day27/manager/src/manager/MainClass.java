package manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {

	public static void main(String[] args) {
		// DB
		Map<Integer, MemberDto> db = new HashMap<>();
		
		
		// C(insert)
		MemberDto vo1 = new MemberDto(1, "test1", "1234", "nick1");
		vo1.setRegdate(new Date());
		MemberDto vo2 = new MemberDto(2, "test2", "1234", "nick2");
		vo2.setRegdate(new Date());
		MemberDto vo3 = new MemberDto(3, "test3", "1234", "nick3");
		vo3.setRegdate(new Date());
		
		db.put(1, vo1);
		db.put(2, vo2);
		db.put(3, vo3);
		System.out.println("저장 완료!");
		
		// R(select)
		List<MemberDto> ls = new ArrayList<>(db.values()); // Collection 반환
		for(MemberDto tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("전체조회 완료!");
		
		MemberDto vo = null;
		vo = db.get(1);
		System.out.println(vo);
		
		
		vo = db.get(4);
		System.out.println(vo);
		System.out.println("조회 완료!");
		
		// U(update)
		vo = db.get(1);
		System.out.println(vo);
		
		if(vo != null) { 	// 검색이 될 경우
			vo.setMemverPw("4321");
			vo.setNickname("1nick ");
			db.put(vo.getNum(), vo);
		}
		
		vo = db.get(1);
		System.out.println(vo);
		System.out.println("수정 완료!");
		
		// D(delete)
		db.remove(2);
		
		ls = new ArrayList<>(db.values()); 
		for(MemberDto tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("전체조회 완료!");
		
		db.clear(); // 전체삭제
		
		ls = new ArrayList<>(db.values()); 
		for(MemberDto tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("전체조회 완료!");
	}

}
