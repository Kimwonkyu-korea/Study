package fileWork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class fileWork_1 {

	public static void main(String[] args) {

		String human[] = { "성춘향", "16", "남원시", "156.0" };
		File file = new File("c:\\test\\human.txt");

		//파일 생성
		try {
			String filename = "human.txt";


			if(file.createNewFile()) {
				System.out.println(filename + "파일이 생성되었습니다");
			}else {
				System.out.println(filename + "과 같은 이름의 파일이 있습니다.");

			}


			//파일 저장
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (int i = 0; i < human.length; i++) {
				pw.println(human[i]);
			}
			pw.close();


			
			//파일 읽기
			String lady[] = new String[4];

			BufferedReader br = new BufferedReader(new FileReader(file));

			String str = "";
			int count = 0;
			while((str = br.readLine()) != null) {
				lady[count] = str;
				count++;
			}


			//데이터 출력
			for(String s : lady) {
				System.out.println(s);
			}
			br.close();


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}