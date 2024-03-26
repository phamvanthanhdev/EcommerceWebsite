package com.springbootdemo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@NotBlank(message = "Tên sản phẩm không được để trống!")
	private String productName;
	
	@NotNull(message = "Giá sản phẩm không được để trống!")
	private Float productPrice;
	
	@NotNull(message = "Giảm giá sản phẩm không được để trống!")
	private Float productDiscount;
	
	@NotNull(message = "Ảnh sản phẩm không được để trống!")
	private String productDescription;
	
	@NotNull(message = "Hiển thị hoặc ẩn sản phẩm!")
	private Boolean isShow;
	
	private String createAt;
	
	private String updateAt;
	
	private String productPhoto;
	
	//Photo
	@OneToMany(mappedBy = "product")
	private List<ProductPhoto> productPhotos;
	
	//Category
	@NotNull(message = "Danh mục không được để trống!")
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private Category category;
	
	//Brand
	@NotNull(message = "Thương hiệu không được để trống!")
	@ManyToOne
	@JoinColumn(name = "brandId")
	private Brand brand;
	
	public Product() {}

	public Product(Integer productId, @NotNull String productName, String productPhoto,
			List<ProductPhoto> productPhotos, Category category, Brand brand) {
		this.productId = productId;
		this.productName = productName;
		this.productPhoto = productPhoto;
		this.productPhotos = productPhotos;
		this.category = category;
		this.brand = brand;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public Float getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Float productDiscount) {
		this.productDiscount = productDiscount;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductPhoto() {
		return productPhoto;
	}

	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}

	public List<ProductPhoto> getProductPhotos() {
		return productPhotos;
	}

	public void setProductPhotos(List<ProductPhoto> productPhotos) {
		this.productPhotos = productPhotos;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDiscount=" + productDiscount + ", productDescription=" + productDescription + ", isShow="
				+ isShow + ", createAt=" + createAt + ", updateAt=" + updateAt + ", productPhoto=" + productPhoto
				+ ", productPhotos=" + productPhotos + ", category=" + category + ", brand=" + brand + "]";
	}

	
	
	
	
}
