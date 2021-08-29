# Ex_for(별 찍기예제)

## 이중 for문을 활용한 별 찍기

### **1. ★로 박스모양 만들기**

```
for (int i = 0; i <= 7; i++) {		// i = 0 ~ 7

		for (int j = 0; j <= 7; j++) {	// j = 0 ~ 7
		    System.out.print("★");
		}
		System.out.println("");
}
```


### **2. ★로 삼격형 만들기**

```
for (int i = 7; i >= 0; i--) {		// i = 7 ~ 0 

		for (int j = i; j <= 7; j++) {	// j = i ~ 7
				System.out.print("★");
		}
		System.out.println("");
}
```

### **3. ★로 역삼각형 만들기**

```
for (int i = 0; i <= 7; i++) {		// i = 0 ~ 7

		for (int j = i; j <= 7; j++) {  // j = i ~ 7
				System.out.print("★");
		}
		System.out.println("");
}
 ```
 
 
