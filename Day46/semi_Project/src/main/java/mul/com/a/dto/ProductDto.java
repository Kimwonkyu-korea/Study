package mul.com.a.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto implements Serializable{

	private int	productId;        
	private int categoryId;       
	private String productName;      
	private int productPrice;    
	private String productDesc;	 
	private String productUrl;		 
	private String productIce;       
	private String productShot;
	private MultipartFile productPhoto;

	public ProductDto() {
	}

	public ProductDto(int productId, int categoryId, String productName, int productPrice, String productDesc,
			String productUrl, String productIce, String productShot, MultipartFile productPhoto) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.productUrl = productUrl;
		this.productIce = productIce;
		this.productShot = productShot;
		this.productPhoto = productPhoto;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getproductPrice() {
		return productPrice;
	}

	public void setproductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getProductIce() {
		return productIce;
	}

	public void setProductIce(String productIce) {
		this.productIce = productIce;
	}

	public String getProductShot() {
		return productShot;
	}

	public void setProductShot(String productShot) {
		this.productShot = productShot;
	}

	public MultipartFile getProductPhoto() {
		return productPhoto;
	}

	public void setProductPhoto(MultipartFile productPhoto) {
		this.productPhoto = productPhoto;
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", categoryId=" + categoryId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productDesc=" + productDesc + ", productUrl=" + productUrl
				+ ", productIce=" + productIce + ", productShot=" + productShot + ", productPhoto=" + productPhoto
				+ "]";
	} 
	
}
