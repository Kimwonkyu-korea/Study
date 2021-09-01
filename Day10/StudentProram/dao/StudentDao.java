package dao;

import java.util.Scanner;

import dto.DtoSt;


// DAO (Data Access Object) - CRUD( Create Read Update Delete ) - 추가 삭제 검색 수정
public class StudentDao {
	Scanner sc = new Scanner(System.in);

	private DtoSt stArray[] = new DtoSt[10];
	int count;

	public StudentDao() {	
		// 프로그램을 실행 하기 위해 초기 데이터 값 인가
		stArray[0] = new DtoSt(1001, "홍길동", 90, 85, 100);
		stArray[1] = new DtoSt(1002, "성춘향", 100, 90, 95);
		stArray[2] = new DtoSt(1003, "일지매", 100, 80, 90);

		count = 3;
	}

	public void Create() {	// 학생 정보 입력
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

		stArray[count] = new DtoSt(number, name, kor, eng, math);

		count++;
		System.out.println("count:" + count);
		System.out.println("추가 되었습니다");
	}

	public void Delete() {	// 학생 정보 삭제
		System.out.print("삭제할 학생이름을 입력 >> ");
		String name = sc.next();

		// 검색
		int findIndex = -1;
		for(int i = 0;i < stArray.length; i++) {
			DtoSt dto = stArray[i];
			if(dto != null && name.equals(dto.getName())) {	// 데이터가 있고, 입력한 값과 같을 때
				findIndex = i;
				break;
			}			
		}

		// 삭제
		if(findIndex == -1) {
			System.out.println("학생명단에 없습니다");
		}
		else {
			DtoSt dto = stArray[findIndex];	
			dto.setNumber(0);				// 초기화
			dto.setName("");
			dto.setKor(0);
			dto.setEng(0);
			dto.setMath(0);

			System.out.println("학생 명단에서 삭제했습니다");
		}
	}

	public void Read() {	// 학생 정보 검색
		System.out.print("검색할 학생이름을 입력 >> ");
		String name = sc.next();
		// 검색
		int findIndex = -1;
		for(int i = 0;i < stArray.length; i++) {
			DtoSt dto = stArray[i];
			if(dto != null && name.equals(dto.getName())) {
				findIndex = i;
				break;
			}			
		}

		// 출력
		if(findIndex == -1) {
			System.out.println("학생명단에 없습니다");
		}
		else {
			DtoSt dto = stArray[findIndex];
			System.out.println(dto.toString());
		}
	}

	public void Update() {	// 학생 정보 수정
		System.out.print("수정할 학생이름을 입력 >> ");
		String name = sc.next();

		// 검색
		int findIndex = -1;
		for(int i = 0;i < stArray.length; i++) {
			DtoSt dto = stArray[i];
			if(dto != null && name.equals(dto.getName())) {
				findIndex = i;
				break;
			}			
		}

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

			DtoSt dto = stArray[findIndex];
			dto.setKor(kor);
			dto.setEng(eng);
			dto.setMath(math);

			System.out.println("학생 데이터를 수정했습니다"); 			
		}
	}

	public void allprint() {
		for (int i = 0; i < stArray.length; i++) {
			DtoSt dto = stArray[i];
			if(dto != null && dto.getName().equals("") == false) {
				System.out.println(dto.toString());
			}
		}
	}

}








