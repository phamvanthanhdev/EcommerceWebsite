package com.springbootdemo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_brand")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brandId;
	@NotBlank(message = "Tên không được để trống")
	private String brandName;
	
	private String brandPhoto;
	
	private String CreateAt;
	
	private String UpdateAt;
	
	@OneToMany(mappedBy = "brand")
	private List<Product> products;
	
	public Brand() {}
	

	public Brand(Integer brandId, @NotBlank(message = "Tên không được để trống") String brandName, String brandPhoto,
			String createAt, String updateAt) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandPhoto = brandPhoto;
		CreateAt = createAt;
		UpdateAt = updateAt;
	}



	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandPhoto() {
		return brandPhoto;
	}

	public void setBrandPhoto(String brandPhoto) {
		this.brandPhoto = brandPhoto;
	}

	public String getCreateAt() {
		return CreateAt;
	}

	public void setCreateAt(String createAt) {
		CreateAt = createAt;
	}

	public String getUpdateAt() {
		return UpdateAt;
	}

	public void setUpdateAt(String updateAt) {
		UpdateAt = updateAt;
	}

	
}
