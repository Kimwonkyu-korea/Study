import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exception2Class {

	public static void main(String[] args) {
		
	
		// NullPointerException
		String str = null;
		try {
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.out.println("str이 null입니다.");
			e.printStackTrace();
		} 
		
	
		// ArrayIndexOutOfBoundsException
		int arr[] = { 1, 2, 3 };
		
		try {
			arr[3] = 'A';
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("배열범위 초과");
		}catch (Exception e) {		//  상위 Exception
			System.out.println("예외발생");
		}
		
		
		// FileNotFindException
		File file = new File("d:\\xxx");
		FileInputStream is;
		
		try {
			is = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// StringIndexOutOfBoundsException   String str = "java"
		String str1 = "java";
		
		str1.charAt(4);
		
		try {
			str1.charAt(4);
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		// NumberformatException
		
		try {
			int i = Integer.parseInt("123a5");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
