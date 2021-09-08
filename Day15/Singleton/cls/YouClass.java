package cls;

import single.Singleton;

public class YouClass {

	private String name;
	private int age = 25;
	/*
   public void setName(String name) {
      this.name = name;
   }
	 */


	
	public void func() {
		Singleton si = Singleton.getInstance();
		name = si.sname;
	}

	public void method() {
		Singleton si = Singleton.getInstance();
		si.sage = age;
	}

	@Override
	public String toString() {
		return "YouClass [name=" + name + "]";
	}
}