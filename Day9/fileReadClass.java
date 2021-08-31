package fileRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class fileReadClass {

	public static void main(String[] args) {

		File file = new File("c:\\Test\\newfile.txt");
		try {
			/*
		 // 한 글자씩 읽기

			FileReader fr = new FileReader(file);
			int ch;

			while((ch = fr.read())!= -1) {		// file 끝이 아닐 때
				System.out.println((char)ch);
			}
			fr.close();
			 */

			// 한 문장씩 읽기
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String str = "";
			while( (str = br.readLine()) != null) {
				System.out.println(str);
			}
			br.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

