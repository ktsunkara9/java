package inc.skt.productservice.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;

	@Transient
	private String couponCode;

	public Product() {
	}

	public Product(String name, String description, BigDecimal price, String couponCode) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.couponCode = couponCode;
	}

	public Product(Long id, String name, String description, BigDecimal price, String couponCode) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.couponCode = couponCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", couponCode=" + couponCode + "]";
	}

}
