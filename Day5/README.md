##  **1. 조건 문**


**1.1 if 1개의 조건**

- **if의 괄호 안에 조건식(논리형 변수나 논리 연산)결과 따라 중괄호{} 블록 실행 여부 결정할때 사용한다.**
```
if( 조건 ){	->	논리연산(true/false) 
 	처리 
}
   조건 : A > B	  if( A > B )		
 			<		if( B < A )
 			==		if( A == B )
 			>=		if( A >= B )
 			<=		if( A <= B )
 			!=		if( A != B )
```


**1.2 if else 2개 중의 하나의 조건**

- **조건식이 참이면 참에 대한 문장을 실행한다.**

- **조건식이 거짓이면 거짓에 대한 문장을 실행한다.**
```
if( 조건 ){
	처리1
}
else{
	처리2
}
```


**1.3 if else if (조건 분기) - 다수의 조건의 경우**

- **복수의 조건식을 두어 조건식을 만족하는 블록만 실행한다.**
```
if( 조건1 ){
	처리1
}
else if( 조건2 ){
	처리2
}
else if( 조건3 ){
	처리3
}
else if( 조건4 ){
	처리4
}
else{ 		// 생략 가능
	처리5
}
```


**1.4 switch 다수의 조건의 경우**

- **변수나 연산식의 값에 따라 실행문 선택할 때 사용한다.**

- **case의 비교 값과 일치하면 해당 case의 실행문장 수행한다.**

- **case의 비교 값과 일치하는 것이 없으면 default문을 실행한다.(default 생략가능)**  
- **값이 명확해야 된다.**  
- **범위를 지정할 수 없다.**
```
switch( 대상이 되는 변수 ) {
	case 값1:	if( 대상이 되는 변수 == 값1 )
		처리1
		break;
	case 값2:	else if( 대상이 되는 변수 == 값2 )
		처리2
		break;
	case 값3:
		처리3
		break;
	default:	== else
}
```

##  **2. 반복 문**

### **2.1 for**

**2.1.1 단순 for** 
- **지정 회수에 따라서 반복하는 제어문**
```
for( (선언)초기화 ; 조건식 ; 연산식 ){
		처리 
	}
		 			
	for( (1) ; (2)(5)(8)(11) ; (4)(7)(10) ){
		처리 (3)(6)(9)	--> 3번
	}
		 		
	(12)
```	

**2.1.2 증감( ++, -- )**
```
int n;
		
for( n = 0; n < 3; n++) {			// n이 1씩 증가
	System.out.println("for 문 ++ ");
}
		
for( n = 3; n > 0; n--) {			// n이 1씩 감소
	System.out.println("for 문 -- ");
}
		
for( n = 0; n < 10; n = n + 2 ) {	// i = 0, 2, 4, 6, 8
	System.out.println("for 문 +2 n = " + n);
}
		
for(int i = 0; i < 10; i++) {		// i = 0 ~ 9
	System.out.println("i = " + i);
}
		
for(int i = 1; i <= 10; i++) {		// i = 0 ~ 10
	System.out.println("i = " + i);
}
```

**2.1.3 이중 for문**

- **반복문안에 반복문이 포함된 구조**

- **중첩 반복 제한이 없음**

- **너무 많은 중첩 반복은 프로그램 구조를 복잡하게 만듬(2중 or 3중 권장)**
```
for(int i = 0; i < 5; i++) {		// i = 0 1 2 3 4 
			
	System.out.println("i = "+ i);
	for(int j = 0; j < 4; j++) {	// j = 0 1 2 3 
		System.out.println("\tj= "+ j);
		}
	}
```

**2.1.4 for if Array**
```
int Array[] = { 90, 100, 55, 85, 70, 45, 80 };
		
for(int i = 0; i < Array.length; i++) {		// for과 배열 함께 쓸 때
	if(Array[i] < 60) {
	System.out.println(Array[i]);
	}
}
```

### **3. while**

- **조건에 따라서 반복의 여부 결정할 때 사용한다.**
```
초기화
while(조건식){	
	처리					
	연산식			
}
```

### **4. do-while**

- **반드시 중괄호{} 실행문을 한 번 실행한다.**
```
초기화		 		
do {
	처리
	연산식
}while(조건식);
```

### **5. break**
**5.1 반복문을 빠져 나가지 않으면서 다음 반복으로 진행한다.**  
  
**5.2 for문과 while, do-while문에서 사용된다.**  
  
**5.3 for문은 증감식, while과 do-while문은 조건식으로 이동한다.***
```
for(int i = 0; i < 10; i++){
	if(조건){
		break;
	}
}
```

**- 배열에서 문자 찾기**
```
char cArray[] = { 'a', 'b', 'c', 'd'};
		
for(int i = 0; i < cArray.length; i++) {
	System.out.println("i = " + i);
	if(cArray[i] == 'c') {
		System.out.println("c를 찾았습니다.");
		break;
	}
}
```

**- 특정 지점에서 break**
```
int array[] = { 11, 22, 33 ,44 ,55 };

for(int num : array) {
	System.out.println(num);
	if(num == 22) {
		break;
	}
}
```

### **6. continue**

**6.1 반복문 하나를 완전하게 빠져 나갈 때 사용한다.**  
  
**6.2 중첩 반복문일 때 가장 근접한 반복문 중괄호{}만 빠져나간다.**

- ** Ex) 숫자 입력 5개**  
- **조건: 음수를 입력받으면 안된다**

```
int number;
int loop = 0;
		
while(loop < 5) {
	System.out.print((loop + 1) + "번째 수 = ");
			
	number = sc.nextInt();
			
	if(number < 0) {
		System.out.println("음수를 입력하셨습니다. 다시 입력해 주세요");
		continue;
	}
			
	loop++;
}
```
