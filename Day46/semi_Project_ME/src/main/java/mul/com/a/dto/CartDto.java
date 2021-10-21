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
