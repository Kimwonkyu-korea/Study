package cls;

public class ParantClass {
	
	private String name;
	private int nember;
	
	public ParantClass() {
		
	}
	
	public ParantClass(String name, int nember) {
		this();
		this.name = name;
		this.nember = nember;
	}

	public void pMethod( ) {
		System.out.println("ParantClass pMethod");
	}
}
