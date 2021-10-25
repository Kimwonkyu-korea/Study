# 장바구니 구현



#### sqls/Cart.xml

- 장바구니 추가
  - 상세페이지에서 hidden값을 설정해서 가져온 것을 장바구니에 insert 해준다.

```xml
<insert id="insertProduct" parameterType="mul.com.a.dto.CartDto">
 insert into TBL_CART(order_id, user_id, product_id, product_name, product_price, order_count, total_price, order_date) values
( ORDER_ID.NEXTVAL, #{user_id},#{product_id},#{product_name}, #{product_price}, #{order_count}, #{total_price}, sysdate )
</insert>
```



- 장바구니 조회
  - 3개 테이블을 join 한다.
  - user_id에 대해서 조회한다.

```xml
<select id="cartlist" parameterType="String" resultType="mul.com.a.dto.CartDto">
SELECT order_id, C.user_id, C.product_id, 
	   order_date, C.product_price,
	   P.product_name, order_count, 
	   (P.product_price*order_count) total_price
FROM   CF_PRODUCT P, CF_USER U, TBL_CART C
WHERE  U.user_id = C.user_id AND c.product_id = p.product_id AND C.user_id=#{user_id}
ORDER BY order_id
</select>
```



- 선택한 품목 취소
  - 회원 ID와 주문 번호를 통해서 개별 삭제

```xml
<delete id="delete" parameterType="mul.com.a.dto.CartDto">
	DELETE FROM TBL_CART
	WHERE user_id=#{user_id} AND order_id=#{order_id}
</delete>
```



- 장바구니 비우기
  - 로그인 한 회원 ID로 전체 삭제

```xml
<delete id="deleteAll" parameterType="String">
	DELETE FROM TBL_CART
	WHERE user_id=#{user_id}
</delete>
```



### Model

#### CartDto.java

- 필요로 하는 데이터 값들을 private으로 선언해준다.
- 자신의 메소드를 만들어준다.
- ~~using fild를 해준다
- getter, setter를 설정해준다.
- 필요 시 to string까지 해준다.

```java
package mul.com.a.dto;

import java.io.Serializable;

public class CartDto implements Serializable{

	private int order_id;		// 주문 번호
	private String user_id;		// 유저 id
	private String order_date;	// 주문 날짜
	private String product_name;// 상품 이름
	private int product_id;		// 상품 코드
	private int product_price;	// 상품 단가
	private int order_count;	// 주문 수량
	private int total_price;	// 합계
	
	// 자기 자신을 만들어줘야된다.
	public CartDto() {
	}

	public CartDto(int order_id, String user_id, String order_date, String product_name, int product_id,
			int product_price, int order_count, int total_price) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.order_date = order_date;
		this.product_name = product_name;
		this.product_id = product_id;
		this.product_price = product_price;
		this.order_count = order_count;
		this.total_price = total_price;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getOrder_count() {
		return order_count;
	}

	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
}
```





#### **CartDao.java** 

```java
package mul.com.a.dao;

import java.util.List;

import mul.com.a.dto.CartDto;

public interface CartDao {

	 boolean insertProduct(CartDto dto); // 장바구니 담기
	
	 List<CartDto> cartlist(String user_id); // 해당 유저 장바구니 목록
	  
	
	 boolean delete(CartDto dto); // 장바구니 개별 삭제
	  
	  
	 boolean deleteAll(CartDto dto); // 해당 유저 장바구니 비우기 
	
}
```



#### **CartDaoImpl.java** 

- **CartDao.java**에서 Override 해준다
- SqlSession을 이용한다.
- return 값을 설정해준다.

```java
@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	SqlSession session;
	
	String ns = "Cart.";

	@Override
	public List<CartDto> cartlist(String user_id) {
		return session.selectList(ns + "cartlist", user_id);
	}
	
	 @Override
	 public boolean delete(CartDto dto) { 
		 int n = session.delete(ns + "delete", dto);
		 return n>0?true:false;
	 }

	@Override
	public boolean deleteAll(CartDto dto) {
		int n = session.delete(ns + "deleteAll", dto);
		return n>0?true:false;
	}

	@Override
	public List<CartDto> ordercheck(CartDto dto) {
		return session.selectList(ns + "ordercheck", dto);
	}

	@Override
	public boolean insertProduct(CartDto dto) {
		int n = session.insert(ns + "insertProduct", dto);
		return n>0?true:false;
	}	
}
```



#### CartService.java

- dao와 마찬가지로 설정 해준다.

```java
package mul.com.a.service;

import java.util.List;

import mul.com.a.dto.CartDto;

public interface CartService {
	
	List<CartDto> cartlist(String user_id);
	
	boolean delete(CartDto dto);
	
	boolean deleteAll(CartDto dto);
	
	List<CartDto> ordercheck(CartDto dto);
	
	boolean insertProduct(CartDto dto);
}
```



#### **CartServiceImpl.java**

- CartService를 Override해준다.
- return값으로 dao를 리턴한다.

```java
@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao dao;

	@Override
	public List<CartDto> cartlist(String user_id) {
		return dao.cartlist(user_id);
	}

	@Override
	public boolean delete(CartDto dto) {
		return dao.delete(dto);
	}

	@Override
	public boolean deleteAll(CartDto dto) {
		return dao.deleteAll(dto);
	}

	@Override
	public List<CartDto> ordercheck(CartDto dto) {
		return dao.ordercheck(dto);
	}

	@Override
	public boolean insertProduct(CartDto dto) {
		return dao.insertProduct(dto);
	}	
}
```



### Controller

#### **CartController.java** 

- @RequestMapping을 해주고 value와 method 방식을 설정해준다.
- 메소드를 만들고 필요한 매개변수를 선언한다.
- service를 해준다.
- model에 값을 넣어서 가져갈 데이터를 더해준다.
- return에 이동할 페이지를 적어준다.

```java
package mul.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mul.com.a.dto.CartDto;
import mul.com.a.service.CartService;


@Controller
public class CartController {
	
	private static Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	CartService service;

	 @RequestMapping(value = "/cartlist.do", method = RequestMethod.GET) 
	 public String cartlist(String user_id, Model model, CartDto dto) {
		 logger.info("CartController cartlist() " + new Date());
		  
		 List<CartDto> list = service.cartlist(user_id);
		 System.out.println(list);
		 
		 model.addAttribute("cartlist", list);
		 model.addAttribute("user_id", user_id);
		 model.addAttribute("dto", dto);

		 return "cart/cartlist";

	 }
	 
	 @RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	 public String delete(CartDto dto,Model model) {
		 logger.info("CartController delete() " + new Date());
		 
		boolean b = service.delete(dto);
		
		if(b == true) {
			return "redirect:/cartlist.do?user_id="+dto.getUser_id()
			+"&order_id="+dto.getOrder_id();
		}
		return "redirect:/cartlist.do";
	 }
	 
	 @RequestMapping(value = "/deleteAll.do", method = RequestMethod.GET)
	 public String deleteAll(CartDto dto,Model model) {
		 logger.info("CartController deleteAll() " + new Date());
		 
		boolean b = service.deleteAll(dto);
		
		if(b == true) {
			return "redirect:/cartlist.do?user_id="+dto.getUser_id();
		}
		return "redirect:/cartlist.do";
	 }
	 
	 @RequestMapping(value="/ordercheck.do", method = RequestMethod.POST)
	public String ordercheck(Model model, CartDto dto, HttpServletRequest req, HttpSession session) {
		
		String  productName = req.getParameter("productName");
		int productId = Integer.parseInt(req.getParameter("productId"));
		int productPrice = Integer.parseInt(req.getParameter("productPrice"));
		int amount = Integer.parseInt(req.getParameter("amount"));
		int total_price  = productPrice * amount;
		String userId = (String)session.getAttribute("id");
		
		System.out.println("id라네용 : "+session.getAttribute("id"));
		
		
		dto.setProduct_id(productId);
		dto.setProduct_name(productName);
		dto.setProduct_price(productPrice);
		dto.setTotal_price(total_price);
		dto.setOrder_count(amount);
		dto.setUser_id(userId);
		
		boolean b = service.insertProduct(dto);
		
		String insert = "NO";
		if(b) {
			insert = "YES";
		}
		model.addAttribute("insert", insert);
		
		return "message2";

	}
		
	@RequestMapping(value="/paysuccess.do", method = RequestMethod.GET)
	public String paysuccess() {
		return "cart/paysuccess";
	}
}
```



### view

#### Cartlist.jsp

- Controller에서 데이터를 전달 받는다. -> request.getAttribute

```java
<%@page import="mul.com.a.dto.CartDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
List<CartDto> list = (List<CartDto>)request.getAttribute("cartlist");
String user_id = (String)request.getAttribute("user_id");
System.out.println(list.toString());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문확인 - Cafe Order</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<!-- 현재 무조건 결제완료 창으로 넘어가게 해놨음!! 나중에 결제수단 구현하면 링크 바꿔주기 -->
<!-- 주문한 게 없는데 주문하기 버튼 누를경우: 주문 먼저 해달라는 글 띄우기 -->

<div align="center" class="order_Allwrapper">

<h3>주문 정보</h3>

<table>
<col width="300px"><col width="100px"><col width="70px"><col width="100px">

<thead>
<tr>
	<th>메뉴</th><th>가격</th><th>수량</th><th>총액</th>
</tr>
</thead>

<tbody>

<%
if(list == null || list.size() == 0){	// 받아온 장바구니가 없거나 장바구니에 메뉴가 하나도 없는 경우
%>	
	<tr align="center">
		<td colspan="4" style="color:gray">아직 주문하신 메뉴가 없어요!</td>
	</tr>
<%	
} else{	// 장바구니가 담은 메뉴가 있는 경우
	
	int totalprice = 0;
	for(int i = 0 ; i < list.size() ; i++) {
		CartDto cart = list.get(i);
	%>
	<tr align="center">
		<th><%=cart.getProduct_name() %></th>
		<td><%=cart.getProduct_price() %></td>
		<td><%=cart.getOrder_count() %></td>
		<td><%=cart.getTotal_price() %></td>
		<td>
			<a href="delete.do?user_id=<%=cart.getUser_id() %>&order_id=<%=cart.getOrder_id() %>">삭제</a>
		</td>
	</tr>
	<%
		totalprice += cart.getTotal_price();
	}
	%>
	<tr>
		<th align="right" colspan="3">합계</th>
		<td><%=totalprice %>원</td>
	</tr>
<%
}	
%>

</tbody>
</table>

<br><br>

<div align="center">
<button type="button" onclick="deleteAll('<%=user_id%>')">장바구니 비우기</button>	
</div>

<br><br>

<input type="button" id="orderBtn_payment" onclick="location.href = 'paysuccess.do'" value="결제하기">
<input type="button" id="orderBtn_payment" onclick="history.back()" value="결제취소">

</div>

<script type="text/javascript">
function deleteAll(user_id) {
	location.href = "deleteAll.do?user_id=" + user_id;
}
</script>
</body>
</html>
```

