package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dto.StudentDto;

// DAO (Data Access Object) - CRUD( Create Read Update Delete ) - 추가 삭제 검색 수정
public class StudentDao {
	Scanner sc = new Scanner(System.in);
	
	//private StudentDto stArray[] = new StudentDto[10];
	private List<StudentDto> list = new ArrayList<StudentDto>();
	
	//int count;
	
	public StudentDao() {
		
	//	stArray[0] = new StudentDto(1001, "홍길동", 90, 85, 100);
	//	stArray[1] = new StudentDto(1002, "성춘향", 100, 90, 95);
	//	stArray[2] = new StudentDto(1003, "일지매", 100, 80, 90);
		
		list.add(new StudentDto(1001, "홍길동", 90, 85, 100));
		list.add(new StudentDto(1002, "성춘향", 100, 90, 95));
		list.add(new StudentDto(1003, "일지매", 100, 80, 90));
		
	//	count = 3;
	}

	public void Create() {
		System.out.print("학생번호 = ");
		int number = sc.nextInt();
		
		System.out.print("학생이름 = ");
		String name = sc.next();
		
		System.out.print("국어 = ");
		int kor = sc.nextInt();
		
		System.out.print("영어 = ");
		int eng = sc.nextInt();
		
		System.out.print("수학 = ");
		int math = sc.nextInt();
		
	//	stArray[count] = new StudentDto(number, name, kor, eng, math);
		list.add(new StudentDto(number, name, kor, eng, math));
		
	//	count++;
	//	System.out.println("count:" + count);
		System.out.println("추가 되었습니다");
	}
	
	public void Delete() {	// 학생 정보 삭제
		System.out.print("삭제할 학생이름을 입력 >> ");
		String name = sc.next();
		
		// 검색
		/*
		int findIndex = -1;
		for(int i = 0;i < stArray.length; i++) {
			StudentDto dto = stArray[i];
			if(dto != null && name.equals(dto.getName())) {
				findIndex = i;
				break;
			}			
		}
		*/
		int findIndex = search(name);		
				
		// 삭제
		if(findIndex == -1) {
			System.out.println("학생명단에 없습니다");
		}
		else {
			/*
			StudentDto dto = stArray[findIndex];
			dto.setNumber(0);
			dto.setName("");
			dto.setKor(0);
			dto.setEng(0);
			dto.setMath(0);
			*/
			list.remove(findIndex);
			
			System.out.println("학생 명단에서 삭제했습니다");
		}
	}
	
	public void Read() {	// 학생 정보 검색
		System.out.print("검색할 학생이름을 입력 >> ");
		String name = sc.next();
		
		// 검색
		/*
		int findIndex = -1;
		for(int i = 0;i < stArray.length; i++) {
			StudentDto dto = stArray[i];
			if(dto != null && name.equals(dto.getName())) {
				findIndex = i;
				break;
			}			
		}
		*/
		int findIndex = search(name);
		
		
		// 출력
		if(findIndex == -1) {
			System.out.println("학생명단에 없습니다");
		}
		else {
		//	StudentDto dto = stArray[findIndex];
			StudentDto dto = list.get(findIndex);
						
			System.out.println(dto.toString());
		}
	}
	
	public void Update() {	// 학생 정보 수정
		System.out.print("수정할 학생이름을 입력 >> ");
		String name = sc.next();
		
		// 검색
		/*
		int findIndex = -1;
		for(int i = 0;i < stArray.length; i++) {
			StudentDto dto = stArray[i];
			if(dto != null && name.equals(dto.getName())) {
				findIndex = i;
				break;
			}			
		}
		*/
		int findIndex = search(name);
				
		// 수정
		if(findIndex == -1) {
			System.out.println("학생명단에 없습니다");
		}
		else {		
			// 입력
			System.out.println("수정할 데이터를 입력해 주십시오");
			System.out.print("국어 = ");
			int kor = sc.nextInt();
			
			System.out.print("영어 = ");
			int eng = sc.nextInt();
			
			System.out.print("수학 = ");
			int math = sc.nextInt();
						
		//	StudentDto dto = stArray[findIndex];
			StudentDto dto = list.get(findIndex);
			
			dto.setKor(kor);
			dto.setEng(eng);
			dto.setMath(math);
			
			System.out.println("학생 데이터를 수정했습니다"); 			
		}
	}
	
	public int search(String name) {
		int findIndex = -1;
		
		for(int i = 0;i < list.size(); i++) {
			StudentDto dto = list.get(i);
			
			if(name.equals(dto.getName())) {
				findIndex = i;
				break;
			}			
		}
		
		return findIndex;
	}
	
	public void allprint() {
		/*
		for (int i = 0; i < stArray.length; i++) {
			StudentDto dto = stArray[i];
			if(dto != null && dto.getName().equals("") == false) {
				System.out.println(dto.toString());
			}
		}
		*/
		
		for (int i = 0; i < list.size(); i++) {
			StudentDto dto = list.get(i);
			System.out.println(dto.toString());
		}
		
	}
	
}








