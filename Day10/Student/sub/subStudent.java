package sub;

public class subStudent {
	
	public String name;
	public int ban;
	public int no;
	public int kor;
	public int eng;
	public int math;
	public int total;
	public double ave;
	
	public int getTotal(int kor, int eng, int math) {
		 
		total = kor + eng + math;
		return total;
	}

	public double getAverage() {
		
		ave = (kor + eng + math) / 3;
		
		return ave;
	}
	

	
}
