# 상속(extends)

## 의미

- **부모 클래스**(상위 클래스)와 **자식 클래스**(하위 클래스)가 있으며, 자식 **그 부모의 멤버를 상속받아 그대로 쓸 수 있게** 됩니다.
- 객체 지향 프로그래밍을 구성하는 3대요소 중 캡슐화, 다형성, **상속성 **하나이다.



## 장점

1. 클래스를 재활용할 수 있는 재사용성에 용이하다.
2. 자식(서브)클래스에서 중복되는 멤버를 부모(메인)클래스에 작성하면, 자식(서브)클래스에서는 작성하지 않아도 된다.
3. 다형성을 토대로 문법을 마련하고, 클래스 간의 계층적 관계를 구성한다.



## 문법

- 자식 클래스에서 선언

- extend는 지정된 형식이다.

  ```
  class 자식클래스명 extend 부모클래스명 { ... }
  ```

  ![image-20210906221029330](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20210906221029330.png)

- Object클래스 상속

  ```java
  class 부모클래스 extends Object { ... }
  
  class 자식클래스 extends 부모클래스 { ... }
  ```

  

### super와 this

- super = 부모클래스의 변수나 메소드, 생성자에 접근
- this = 자기 자신의 생성자를 호출
- super와 this는 같이 사용 할수 없다.
- 메소드 상단에 위치해 있어야 한다.

```java
public class ChildClass extends ParentsClass{  
    
	private String address;
	public ChildClass() {
		super("성춘향", 16);    
	}
    public ChildClass(String name, int number, String address, int age) {
		super(name, number, age);
		this.address = address;
	}
}

    
```



### Overriding(오버라이딩)와 Overloading(오버로딩)

- **Overriding(오버라이딩)** - 상속받은 메소드를 고쳐서 기입하는 것을 의미한다.
- **Overloading(오버로딩)** - 동일한 메소드를 가지면서 매개변수의 유형과 개수가 다르도록 하는 것