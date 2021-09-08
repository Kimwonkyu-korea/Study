package single;

public class Singleton {

	private static Singleton si = null;
	public String sname;
	public int sage;
	
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		if(si == null) {
			si = new Singleton();
		}
		return si;
	}
}
