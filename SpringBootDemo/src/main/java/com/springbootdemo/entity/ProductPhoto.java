package com.springbootdemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_product_photo")
public class ProductPhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer photoId;
	
	private String photoUrl;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	public ProductPhoto(Integer photoId, String photoUrl, Product product) {
		this.photoId = photoId;
		this.photoUrl = photoUrl;
		this.product = product;
	}

	public ProductPhoto() {
		super();
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
