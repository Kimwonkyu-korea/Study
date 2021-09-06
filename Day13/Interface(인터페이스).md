# Interface(인터페이스)

### 의미 

- 추상 메소드로 선언만 되어 있는 비어 있는 클래스이다.
  		 				

### 특징

1. 메소드의 타입만이 설정되어 있다.
2. 다중 상속이 가능하다.
3. 빠르게 클래스의 사양을 파악할 수 있다.
4. 코드를 수정하지 않아도, 객체만으로 변경할 수 있도록 할수 있다.

![image-20210906223315942](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20210906223315942.png)

### 선언

- 변수는 선언이 불가능하다.
- 멤버 메소드 선언이 불가능하다.

```java
public interface 인터페이스이름 { ... }
```

- Interface는 extends가 아닌 **implements**이다.

```java
public class MyClass implements MyInterface
```

- 다중 인터페이스 구현이 가능하다.(extends 불가능)

```java
public class YouClass implements HeInterface, SheInterface
```

