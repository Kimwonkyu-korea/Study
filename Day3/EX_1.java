public class MainClass {

	public static void main(String[] args) {
		String HongName = "\"홍길동\"";	// back end
		String IlName = "\"일지매\"";
		String JangName = "\"장옥정\"";
		
		int HongInt = 20;
		int IlInt = 18;
		int JangInt = 14;
		
		boolean T = true;
		boolean F = false;
		
		String HongHhone = "010-111-2222";
		String IlHhone = "02-123-4567";
		String JangHhone = "02-345-7890";
		
		double HongHei = 175.12;
		double IlHei = 180.01;
		double JangHei = 155.78;
		
		String Hongadd = "\"경기도\"";
		String Iladd = "\"서울\"";
		String Jangadd = "\"부산\"";
		
		// front end
		System.out.println("========================================================");
		System.out.println("\\ name  age     lady    phone           height  address"+"\t\\");
		System.out.println("\\========================================================");
		System.out.println("\\"+HongName+"\t"+HongInt+"\t"+T+"\t"+HongHhone+"\t"+HongHei+"\t"+Hongadd+"\t\\");
		System.out.println("\\"+IlName+"\t"+IlInt+"\t"+T+"\t"+IlHhone+"\t"+IlHei+"\t"+Iladd+"\t\\");
		System.out.println("\\"+JangName+"\t"+JangInt+"\t"+F+"\t"+JangHhone+"\t"+JangHei+"\t"+Jangadd+"\t\\");
		System.out.println("========================================================");
	
	}
	
}