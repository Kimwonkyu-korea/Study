## 입력과 출력

"문자열"  -> character

\n -> 개행

printf 출력

%d = 숫자, %c 문자, %s 문자열

### String == 문자열

System.out.println();

### 입력 받기 위한 절차

Scanner scan = new Scanner(System.in); 

#### boolean = > true / false

boolean b;

b = scan.nextBoolean();

System.out.println(b);



### integer 정수

int num;

num = scan.nextInt();

System.out.println(num);



### double 소수

double d;

d = scan.nextDouble();

System.out.println(d);



### String 문자열

String str;
str = scan.next();
System.out.println(str);



BufferedReader Buffer(저장공간)

String str = "";

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

System.out.print("str = ");

try {

str = br.readLine(); // 실제 입력 -> 띄어 쓰기가 가능하다.
}catch (Exception e) {

}
## 상수(숫자) 
### 의미 : 변할 수 없는 수(지정 숫자) ###

2진수 : 0, 1

8진수 : 0 ~ 7 8 -> 10 9 -> 011

10진수 : 0 ~ 9

16진수 : 0 ~ 9 A B C D E F(15) 16 -> 0x10 15 -> 0xF


## **Variable(== 변수)**

값을 임의로 저장하기 위한 공간(메모리)

그릇 -> 데이터

이름을 정해 준다.

크기 -> 데이터의 종류(정수, 실수, 문자열, 문자, 논리(true/false))

자료형 변수명; 변수의 선언

EX) int number;



## ** 변수(그릇)의 종류**
### 정수
1 byte 256개 -> 0 ~ 255 0000 0000 0 -> + 1 -> -
-128 ~ 127

short == 2 byte

integer == 4 byte integer

long ==  8 byte

### 실수

float == 4 byte

double == 8 byte

d = 234.5678912345;

### 문자

char == 2 byte character

### 문자열(String) == object


### 논리 
#### 참(true)/거짓(false)

boolean == 1 byte

\n(개행), \"(따옴표), \', \t(띄어쓰기)
