
public class MethodWork3 {

	public static void main(String[] args) {
		/*
		  메소드명 : isNumber
		  기능 : 주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다.
		  모두 숫자로만 이루어져 있으면 true를 반환하고,
		  그렇지 않으면 false를 반환한다.

		 */

		boolean b = isNumber("19374");
		if(b == true) {
			System.out.println("모두 숫자입니다.");
		}else {
			System.out.println("문자가 있습니다.");			
		}
	}

	static boolean isNumber(String str) {

		boolean b = true;

		for(int i =0; i < str.length(); i++) {
			char c = str.charAt(i);
			//			System.out.println(c);

			int asc = (int)c;
			if(asc < 48 || asc >57) {	// 48 == '0'   57 == '9'
				b = false;
				System.out.println("숫자가 아닙니다.");

				// if(c != '0' && c!= '1' && c != '2' && c != '3' && c != '4' &&)
			}
		}
		return b;
	}

}