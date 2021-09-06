## Final

### 의미

- **최종적이란 뜻으로 final 필드는 초기값이 저장되면 최종적인 값이 되어 프로그램 실행 도중에 수정을 할 수 없다.**



### **1\. 변수**

- 상수 number, 값을 정해야된다.

- 대문자로 보기 좋게 표시, 대입용

```java
final int NUMBER = 10;
int num = NUMBER;
```



### **2\. 클래스**

- final은 상속을 할 수 없다.

```java
/*final*/class SuperClass{
	public void method() {
	}
}
class ChildClass extends SuperClass{
	public void method() {	
}
```



### **3\. 메소드 **

- Over Ride를 할 수 없다.

```java
class SuperClass{
	public/*final*/void method() {
	}
}
class ChildClass extends SuperClass{
	public void method() {	// Over Ride
	}
}
```