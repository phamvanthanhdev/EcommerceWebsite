package com.springbootdemo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CategoryId;
	@NotBlank(message = "Tên không được để trống")
	private String CategoryName;
	
	private String CategoryPhoto;
	
	private String CreateAt;
	
	private String UpdateAt;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
	public Category() {}

	public Category(int categoryId, String categoryName, String categoryPhoto, String createAt, String updateAt) {
		CategoryId = categoryId;
		CategoryName = categoryName;
		CategoryPhoto = categoryPhoto;
		CreateAt = createAt;
		UpdateAt = updateAt;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getCategoryPhoto() {
		return CategoryPhoto;
	}

	public void setCategoryPhoto(String categoryPhoto) {
		CategoryPhoto = categoryPhoto;
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

	@Override
	public String toString() {
		return "Category [CategoryId=" + CategoryId + ", CategoryName=" + CategoryName + ", CategoryPhoto="
				+ CategoryPhoto + ", CreateAt=" + CreateAt + ", UpdateAt=" + UpdateAt + "]";
	}
	
}
