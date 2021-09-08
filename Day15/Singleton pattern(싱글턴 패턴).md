# Singleton pattern(싱글턴 패턴)

## 의미

- **전역 변수를 사용하지 않고 객체를 하나만 생성 하도록 하며, 생성된 객체를 어디에서든지 참조할 수 있도록 하는 패턴**



예제를 통해서 알아보기

Myclass에서 String타입의 "홍길동"을  Singleton을 통해서 YouClass로 출력해보기

MainClass.java

```java
public class MainClass {
	public static void main(String[] args) {
	MyClass mycls = new MyClass("홍길동");
		YouClass youcls = new YouClass();
        
		mycls.method();
		youcls.func();
        
		System.out.println(youcls.toString());
    }
}
```



Myclass

- 데이터를 보내는 클래스

```java
public class MyClass {
   private String name;

   public MyClass(String name) {
      this.name = name;
   }
    
   public void method() {	// Singleton 접근
      Singleton si = Singleton.getInstance();
      si.sname = name;
   }
}
```



Youclass

- 데이터를 받는 클래스

```java
public class YouClass {
	private String name;
	private int age = 25;
    
	public void func() {
		Singleton si = Singleton.getInstance();
		name = si.sname;
	}
	
	@Override
	public String toString() {
		return "YouClass [name=" + name + "]";
	}
}
```

