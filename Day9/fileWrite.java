package fileWrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class fileWrite {

	public static void main(String[] args) {
		
		File file = new File("C:\\Test\\newfile.txt");
		
		
		try {
			
			//쓰기
			/*
			FileWriter fwriter = new FileWriter(file);
			
			fwriter.write("안녕" + "\n");
			fwriter.write("Hello");
			fwriter.close(); // 반드시 해줘야된다.
			*/
			
			// 추가쓰기
			/*
			FileWriter fwriter = new FileWriter(file, true);
			fwriter.write("반갑습니다");
			fwriter.close();
			*/
			
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println("안녕하세요");
			pw.print("hello");
			pw.println("world");
			
			pw.close();
			bw.close();
			fw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
