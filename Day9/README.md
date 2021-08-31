# OverLoad

**의미 : 함수(method)명은 같으며 매개 변수의 자료형이나 갯수가 다른 것을 의미한다.**

### **1. 대표적인 Over Load 종류**
```
static void method() {
	System.out.println("method() 호출");
}

static void method(char c) {
	System.out.println("method(char c) 호출");
}
	
static void method(int i) {
	System.out.println("method(int i) 호출");
}
	
static void method(char c, int i) {
	System.out.println("method(char c, int i) 호출");
}
static void method(int i, char c) {
	System.out.println("method(int i, char c) 호출");
}
```

**1.1 출력 화면**

<img src = "https://blog.kakaocdn.net/dn/PUuEX/btrdzNVY8ne/YGMu5eTCl3WGqNxdjQoDz0/img.png">


### **2. 에러가 뜨는 경우**

**2.1 매개변수는 같고 인수만 다를 경우**
```
static void method(int a, char b) {
	System.out.println("method(int i, char c) 호출");
}
```

**2.2 리턴 값이 다를 경우**
```
static int method(char c) {
	System.out.println("method(char c) 호출");
}
```


# Exception

**Exception : 예외 != 에러**

<img src = "https://blog.kakaocdn.net/dn/bRP3Uy/btrdHkSFAeO/2n8EX5tcwmKuukxhvYPQBk/img.png">

### **1. 형식 :** 

- **예외 클래스 한정이 없다.**
```
try {
	-예외가 발생될 수 있는 코드-
}catch(예외 클래스1 e){
	예외1 메시지를 출력
}catch(예외 클래스1 e){
	예외2 메시지를 출력
}catch(예외 클래스1 e){
	예외3 메시지를 출력
}finally{
	---	무조건 실행 ! ---
	rollback(복구) - undo
}
```

### **2. 오류 확인**
```
try {
	-예외가 발생될 수 있는 코드-
}catch(ArrayIndexOutOfBoundsException e) {
	// e.printStackTrace();
	// System.out.println(e.getMessage());
}
```

### **3. finally**

- **finally 부분은 무조건 실행**
```
try {
		-예외가 발생될 수 있는 코드-
			}
}catch(ArrayIndexOutOfBoundsException e) {
        System.out.println(e.getMessage());
		return;
        
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		System.out.println("finally 부분");
	}
	System.out.println("end");
}
```

### **4. 예외 처리 종류**
<img src = "https://blog.kakaocdn.net/dn/TWi23/btrdDapMnJD/hiQUE8xdxLfLllDlXKUPQK/img.png">

### **5. 결론 및 요약**
```
try {
	-예외가 발생될 수 있는 코드-;
} catch (Exception e) {
	e.printStackTrace();
}
```
- **예외 처리의 종류가 많지만 가장 상위 Exception인 Exception을 사용하면 대체가 가능하다.**


# fileIO

**file : 저장 매체 == 기능**  
**Database(file)**

- **.txt -> 2진수 -> dll, lib, jar, bmp**

### **1. 파일 생성**
```
File newfile = new File("C:\\Test\\newfile.txt");

try {
	if(newfile.createNewFile()) {
		System.out.println("파일 생성 성공!");
	}
	else {
		System.out.println("파일 생성 실패");
	}
}catch(IOException e) {
	e.printStackTrace();
}
```

### **2. 폴더 생성**
```
File newdir = new File("C:\\Test\\subdir");
if(newdir.mkdirs()) {
	System.out.println("폴더 생성 성공!");
}
else {
	System.out.println("폴더 생성 실패");
}
```

### **3. file의 존재 여부**
```
if(newfile.exists()) {
	System.out.println("newfile.txt가 존재합니다.");
}else {
	System.out.println("newfile.txt가 존재하지 않습니다.");
}
```

### **4. file의 읽기 가능 여부**
```
if(newfile.canRead()) {
	System.out.println("이 파일은 읽기가 가능합니다.");
}else {
	System.out.println("이 파일은 쓰기가 불가능합니다.");
}
```

### **5. file의 쓰기 가능 여부**
```
if(newfile.canWrite()) {
	System.out.println("이 파일은 읽기가 가능합니다.");
}else {
	System.out.println("이 파일은 쓰기가 불가능합니다.");
}
```

### **6. 읽기 전용**  
```
newfile.setReadOnly();
```

### **7. 삭제**
```
newfile.delete();
```

# fileWrite & fileRead

### **1. fileWrite**

**1.1 쓰기**
```
FileWriter fwriter = new FileWriter(file);
			
	fwriter.write("안녕" + "\n");
	fwriter.write("Hello");
	fwriter.close();              // 반드시 해줘야된다.
```

**1.2 추가쓰기**
```
FileWriter fwriter = new FileWriter(file, true);
	fwriter.write("반갑습니다");
	fwriter.close();
```
```
FileWriter fw = new FileWriter(file);
	BufferedWriter bw = new BufferedWriter(fw);
	PrintWriter pw = new PrintWriter(bw);
			
	pw.println("안녕하세요");
	pw.print("hello");
	pw.println("world");
			
	pw.close();
	bw.close();
	fw.close();
```

#### **2. fileRead**

### **2.1 한 글자씩 읽기**
```
FileReader fr = new FileReader(file);
	int ch;

	while((ch = fr.read())!= -1) {		// file 끝이 아닐 때
		System.out.println((char)ch);
	}
	fr.close();
```

### **2.2 한 문장씩 읽기**
```
FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);

	String str = "";
	while( (str = br.readLine()) != null) {
		System.out.println(str);
	}
	br.close();
```  

