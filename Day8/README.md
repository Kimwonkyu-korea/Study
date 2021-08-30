#### **1. 배열(Array) :** 같은 자료형 변수들의 묶음

**1.1 관리(접근)는 index number로 관리된다.**

**1.2 배열선언과 초기화**

```
int array[] = new int[10];
array[0] = 10;
		 	
int array[] = { 1, 2, 3};	// 선언과 동시에 초기화
```

**2. 2차원 배열(Array): 배열 안에 또다른 배열을 가지고 있는 형태입니다.**

**2.1 Colum(항목)**
![캡처1](https://user-images.githubusercontent.com/83902559/131346343-eac1a247-a86a-4d38-8771-680f5b1a3828.PNG)

**2.2 2차원 배열 선언과 초기화**

```
char cArray[][] = {		                // = new int [2][5];
		{ 'H', 'e', 'l', 'l', 'o' },
		{ 'W', 'o', 'r', 'l', 'd' },
};
```

**2.3 String 배열을 Integer로 변환 후 합계**

```
String strArr[][] = {
	{ "홍길동", "90" },
	{ "성춘향", "100" },
	{ "정수동", "85" },
};
		
	int sum = 0;
		
	for (int i = 0; i < strArr.length; i++) {
		sum += Integer.parseInt(strArr[i][1]);	// String -> int 변환
	}
	System.out.println("합계 : " + sum);
  ```
  
  #### **Sorting : 정렬(선택)**
  
**1. 2차원 배열에서 최솟값을 찾는다.**

**2. 최솟값을 맨 앞 자리의 값과 비교하고 교환한다.**

**3. 맨 앞 자리를 제외한 나머지 값들 중 최솟값을 찾아 위와 같은 방법으로 반복한다.**

- **in 숫자 : 5 1 4 2 3**


![캡처2](https://user-images.githubusercontent.com/83902559/131347083-b4d736d0-94f8-4e90-a03c-2024371ff919.PNG)



- **오름차순 : 1 2 3 4 5**


![캡처3](https://user-images.githubusercontent.com/83902559/131347122-7ff01d16-2a87-4637-84a2-452fd6d6b8ce.PNG)



- **오름차순 +swap(교환)**
```
if(numbers[i] > numbers[j]) {  	// 오름
	temp = numbers[i];			// swap(교환)
	numbers[i] = numbers[j];
	numbers[j] = temp;
```

- **내림차순  : 5 4 3 2 1**


![캡처4](https://user-images.githubusercontent.com/83902559/131347277-8c02478c-bba2-4404-a683-ba16acdad0a1.PNG)



- **내림차순 + swap(교환)**
```
if(numbers[i] < numbers[j]) {  	// 내림
	temp = numbers[i];			// swap(교환)
	numbers[i] = numbers[j];
	numbers[j] = temp;
```


