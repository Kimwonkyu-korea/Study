package mul.com.a.dto;

import java.io.Serializable;

public class ProductDto implements Serializable{

	private int product_id;
	private int category_id;
	private String product_name;
	private int product_price;
	private String product_ice;
	private String product_shot;
	
	public ProductDto() {
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_ice() {
		return product_ice;
	}

	public void setProduct_ice(String product_ice) {
		this.product_ice = product_ice;
	}

	public String getProduct_shot() {
		return product_shot;
	}

	public void setProduct_shot(String product_shot) {
		this.product_shot = product_shot;
	}

	public ProductDto(int product_id, int category_id, String product_name, int product_price, String product_ice,
			String product_shot) {
		super();
		this.product_id = product_id;
		this.category_id = category_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_ice = product_ice;
		this.product_shot = product_shot;
	}
	
}
