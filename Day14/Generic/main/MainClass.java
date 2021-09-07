package main;

public class MainClass {

	public static void main(String[] args) {
/*
		double d;
		
		MyClass cls = new MyClass();
		// cls == local 변수 == object == 객체
		//		stack		Heap
		cls.number = 123;
		
		// delete cls;
		MyClass clscopy = cls;	// 객체끼리 대입
		
		System.out.println(cls);
		System.out.println(clscopy);
		System.out.println(clscopy.number);
		
		Object obj = cls; // 모든 클래스를 저장할 수 있음(최상위)
		System.out.println(obj);
		
	//	Object yobj = new YouClass();
	//	Object mobj = new MyClass();
		
		Object arrObj[] = new Object[2];
		// 하나로 묶어서 사용
		arrObj[0] = new MyClass(234,"성춘향");
		arrObj[1] = new YouClass();
		
		if(arrObj[0] instanceof MyClass) {
			MyClass mycls = (MyClass)arrObj[0];
			mycls.method();
		}*/
		
		/*
		 	Generic(제네릭) : template(형태)
		 					 자료형(object)의 정의 
		 					 다양한 자료형을 정의할 수 있다.
		 */
		Box<Integer> box = new Box<Integer>(10); // T를 Integer로 셋팅
		System.out.println(box.getTemp() + 23);
		
		Box<String> strbox = new Box<>("Hello");
		System.out.println(strbox.getTemp() + 23);
		
		BoxMap<Integer, String> bmap = new BoxMap<Integer, String>(1001, "홍길동");
		System.out.println(bmap.getKey());
		System.out.println(bmap.getValue());
		
	}
}

class Box<T>{
	
	T temp;

	public Box(T temp) {
		this.temp = temp;
	}

	public T getTemp() {
		return temp;
	}

	public void setTemp(T temp) {
		this.temp = temp;
	}
}

class BoxMap<K, V>{
	K key;
	V value;
	public BoxMap(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}













/*
class MyClass{	// 객체
	int number;
	private String name; 
	
	public MyClass() {
		
	}
	
	public MyClass(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public void method() {
		System.out.println("number" + number);
		System.out.println("name" + name);
	}
}

class YouClass {
	
}
*/