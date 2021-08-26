## Array(배열)


#### **Array(배열)**

의미 : 같은 자료형의 묶음이다.

목적 : 변수들을 관리하기 위함이다.

형식: 자료형 배열변수명[] = new 자료형[배열의 총 갯수];

EX) int Array[ ] = new int[10];


**new란 ?**

- 동적할당 : 정해지지 않는 갯수로 프로그래머가 결정해서 할당

동적 : dynamic 할당 : allocation

  

배열은 프로그램 시작전 프로그래머의 **동적**할당을 통해 정해지고 프로그램을 시작 한 뒤에는  **정적**으로 동작한다.

  

배열의 관리는 배열변수 접근하기 위한 번호인  **index number(번지)** 를 통해서 한다.(0 ~ Array.length-1)

  

**배열의 초기화**

- initialize

int Array[] =  **null**;

- value initialize  
int Array[] = {10, 20, 30, 40, 50, 60};


**char 배열에서 확인하기**

char charArray1[] = { 'W', 'o', 'r', 'l', 'd' };

  

System.out.println(charArray1[0] + charArray1[1] + charArray1[2] + charArray1[3] + charArray1[4]);  
**520 // ASCII 아스키 코드로 출력**

  

System.out.println(  **" "**  + charArray1[0] + charArray1[1] + charArray1[2] + charArray1[3] + charArray1[4]);


**배열 복사**  
int arrayNum[] = { 11, 22, 33 };  
int arrayCopy[] = arrayNum;

  

**같은 메모리 사용한다.**

int ArrayNumberPosition[] = { 1, 2, 3, 4, 5, };  
int ArrNumPos[] = ArrayNumberPosition;

## 연산자 
<img src ="https://blog.kakaocdn.net/dn/yzqJr/btrdeWYQGLw/uqxjBeYEY7wNoxjHFUtFP1/img.png" width="400" height="250">
```


## 타입 변환의 종류

- **자동 타입 변환** - 작은 크기 타입은 큰 크기 타입으로 자동으로 변환된다.

- **강제 타입 변환** - 프로그래머가 강제로 타입을 변환할 수 있다. -> byte a = (byte) n;



## String(문자열) 
###  **String : wrapper class** ###

- **equals - 비교함수**

- **indexOf - 문자의 위치 탐색**

- **length - 문자의 길이**

- **replace - 문자열 바꾸기**

- **split 문자열 자른다. '-' == token**

- **substring - 범위를 설정하여 문자열을 자른다.**

- **문자열 대소문자 바꾸기( toUpperCase(), toLowerCase() )**

- **trim - 문자열의 앞뒤의 공백을 제거**

- **charAt - 배열처럼 사용할 수 있는 함수 0 ~ n-1**

- **contains - 문자열을 탐색**


##  Wrapper Class


- **숫자(Integer) -> 문자열(String)**

       int number = 123; 
       String s = number + ""; 	// 문자열
        		
       Integer inumber = 123; 
       String s1 = inumber.toString();
       
- **문자열(String) -> 숫자(Integer)**

    String strNum = "1024";
    int num = Integer.parseInt(strNum); 
    System.out.println(num * 2);

- **문자열(String) -> 실수(Double)**

    String strNumber = "123.4567";
    double dnum = Double.parseDouble(strNumber);	// 실수
    System.out.println(dnum);
