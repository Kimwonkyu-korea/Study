package cls;

public class PrintPhoneCard implements PrintInterface {

	@Override
	public void print(NameCard nc) {
		System.out.println("전화번호:" + nc.phone);

	}

}
