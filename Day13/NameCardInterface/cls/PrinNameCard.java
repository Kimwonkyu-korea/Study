package cls;

public class PrinNameCard implements PrintInterface {
	
	@Override
	public void print(NameCard nc) {
		System.out.println("이름:" + nc.name);
	}
	
}
