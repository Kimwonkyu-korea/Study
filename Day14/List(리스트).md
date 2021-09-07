# List(리스트) 

## List 컬렉션 클래스

### 1. ArrayList

- ### 생성

  ```java
  List<자료형> list = new ArrayList<자료형>();
  ```

  

- ### add(추가)

  - List에 자료를 넣을 때 사용하는 함수이다.

  - add를 통해서  **순서대로** 추가할 수 있다.

  ```java
  Integer iobj = new Integer(111);
  		list.add(iobj);		// 정석
  		
  		list.add(222);
  
  		list.add(new Integer(333));
  ```

  

  - add를 통해서  **원하는 곳**에 추가할 수 있다.

  ```java
  Integer inum = 200;
  		list.add(1, inum);
  ```



- ### get / size

  - **get**은 List에서 데이터를 **가져올때** 사용이 된다.
  - **size**는 List의 **길이**를 알 수 있는 함수이다.

  ```java
  int index = list.indexOf( 222 );
  		System.out.println("index: " + index);
  		
  		for(int i = 0; i < list.size(); i++) {
  			Integer in = list.get(i);
  			if(in == 200) {
  				System.out.println("index: " + i);
  			}
  		}
  ```



- ### set

  - 데이터를 **수정**할 때 사용된다.

  ```java
  MyClass newObj = new MyClass();
  		newObj.setNumber(22);
  		newObj.setName("LMR");
  		newObj.setHeight(175.9);
  		
  		mlist.set(1, newObj);
  ```

  

- ### Remove

  - 값을 **삭제**할 때 사용 된다.

  ```java
  mlist.remove(2);
  ```

  

-  ### Contains

  - **Contians**는 List에 해당값이 있으면 True, 없으면 False를 리턴해줍니다.(boolean)

  ```java
  System.out.println(list.contains("해당 값"));
  ```

  