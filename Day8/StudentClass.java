
public class StudentClass {

	public static void main(String[] args) {
		
		// 		  name	   kor   eng    math
		String students[][] = {
				{ "홍길동", "90", "85", "100" },
				{ "성춘향", "100", "90", "80" },
				{ "홍두께", "75", "80", "90" },
				{ "정수동", "70", "90", "95" },
				{ "임꺽정", "95", "65", "90" },
		};
		
		// 총점
		int sum = 0;
		
		for (int i = 0; i < students.length; i++) {
			for ( int j = 1; j < students[i].length; j++)
			sum += Integer.parseInt(students[i][j]);	// String -> int 변환		
		}
		System.out.println("총점 : " + sum);
		
		// 총점의 평균
		double avg = sum / (students.length * (students[0].length -1));
		System.out.println("총점의 평균 : " + (avg));
		
		// 학생 한명의 성적출력
		String name = "성춘향";
		for (int k = 1; k <= 3; k++) {
			System.out.print(students[1][k]);
			System.out.print(" ");
		}
		System.out.println("");
		
		// 검색
		int findIndex = -1;
		for(int i = 0; i < students.length; i++) {
			if(name.equals(students[i][0])) {		// 0번지 = 이름
				findIndex = i;
				break;
			}
		}
		System.out.println("findIndex : " + findIndex);
		
		// 학생 한명의 총점
		int s_sum = 0;
		for (int j = 1; j < students[findIndex].length; j++) {
			s_sum += Integer.parseInt(students[findIndex][j]);	// String -> int 변환
		}
		System.out.println("성춘향 총점 : "  + s_sum );
		
		// 학생 한명의 평균
		double s_avg = s_sum/ 3;
		System.out.println("성춘향 총점 : "  + (s_avg) );
		
		// 국어의 총점, 평균
		int kor_sum = 0;
		double kor_avg = 0.0;
		
		for (int i = 0; i < students.length; i++) {
			kor_sum += Integer.parseInt(students[i][1]);
		}
		
		kor_avg = kor_sum/students.length;		// 국어 총점 / 학생 수
		System.out.println("국어의 총점 "  + kor_sum );
		System.out.println("국어의 평균 "  + kor_avg );
	}
	

}
