package Magazine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MagazineDao {
Scanner sc = new Scanner(System.in);

	// 리스트 생성
	private List<MagazineDto> list = new ArrayList<MagazineDto>();
	
	public void insert() {
		System.out.print("바코드를 입력하세요 = ");
		int isbn = sc.nextInt();
		
		System.out.print("잡지 이름을 입력하세요 = ");
		sc.nextLine();		// 앞에 int 값이 있어서 엔터 누를 시 null값이 들어감 -> 공백 nextLine(); 설정
	    String title=sc.nextLine();
		
		System.out.print("저자를 입력하세요 = ");
		String author = sc.nextLine();

		System.out.print("출판사를 입력하세요 = ");
		String publisher = sc.nextLine();
		
		System.out.print("금액을 입력하세요 = ");
		int price = sc.nextInt();
		
		System.out.print("내용을 입력하세요 = ");
		sc.nextLine();
		String desc = sc.nextLine();
		
		list.add(new MagazineDto(isbn, title, author, publisher, price, desc));
		
		System.out.println("추가 되었습니다.");
	}

	public void select() {
		System.out.print("잡지 이름을 입력하세요");

		System.out.print(">> ");
		
		String title = sc.nextLine();
		int findIndex_1 = search(title);
		
		if(findIndex_1 == -1) {
			System.out.println("찾는 항목이 없습니다");
		}
		else {
			MagazineDto dto = list.get(findIndex_1);
			System.out.println("****************** 도서 목록 ******************");
			System.out.println(dto.toString());
		}

	}
	public void filesave() {
		System.out.print("저장할 잡지 이름을 입력하세요 = ");
		String title = sc.nextLine();
		int findIndex= search(title);
		if(findIndex == -1) {
			System.out.println("찾는 항목이 없습니다");
		}
		else {
			System.out.print("파일명을 입력하세요 = ");
			String file = sc.next();
			
			MagazineDto dto = list.get(findIndex);
			File newfile = new File("C:\\Magazine\\"+file);
			try {
				if(newfile.createNewFile()) {
					FileWriter fwriter = new FileWriter(newfile);
					fwriter.write(dto.toString());
					fwriter.close();
					System.out.println("파일 생성 성공!");
				}
				else {
					System.out.println("파일 생성 실패");
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void fileload() {
		System.out.print("파일명을 입력하세요 = ");
		String file = sc.next();
		// 경로에 해당 폴더가 존재해야된다.
		File fileRead = new File("C:\\Magazine\\"+file);
		try {
		FileReader fr = new FileReader(fileRead);
		BufferedReader br = new BufferedReader(fr);

		String dto = "";
		while( (dto = br.readLine()) != null) {
			System.out.println(dto.toString());
		}
		br.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int search(String title) {
		int findIndex = -1;
		
		for(int i = 0;i < list.size(); i++) {
			MagazineDto dto = list.get(i);
			
			if(title.equals(dto.getTitle())) {
				findIndex = i;
				break;
			}			
		}
		
		return findIndex;
	}
}
