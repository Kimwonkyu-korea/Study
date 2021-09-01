package dto;

public class DtoMember {
	
	// 멤버 변수 : 특수한 경우를 제외하고 private이다.
	
	private int number;
	public String name;
	protected double height;
	
	// 멤버 함수(메소드)는 90%이상 public이다.
	
	// getter -> 외부에서 접근할수 있도록 하는 함수. (외부에서)값을 취득
	public int getNumber() {
		return number;
	}
	
	// setter -> (외부에서)값을 변경
	public void setNumber(int num) {
		number = num;
	}
	
	public void method() {
		this.number = 123;
	}
	
	public void func(int number) {
		this.number = number; 	// member 변수 = 매개변수 구분
	}
	
	public DtoMember getThis() {
		return this;	
	}
	// this : 자기 참조 == Heap 영역의 주소
	
	
}
