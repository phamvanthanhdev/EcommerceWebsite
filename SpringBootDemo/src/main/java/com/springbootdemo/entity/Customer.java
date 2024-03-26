package com.springbootdemo.entity;

import java.util.List;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@UniqueElements
	@NotBlank(message = "Email không được để trống")
	private String customerEmail;
	
	@NotBlank(message = "Mật khẩu không được để trống")
	private String customerPassword;
	
	@NotBlank(message = "Tên không được để trống")
	private String customerName;
	
	private boolean sex;
	
	@NotBlank(message = "SĐT không được để trống")
	private String customerPhone;
	
	private String customerAddress;
	
	private String createAt;
	
	private boolean isLock;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	public Customer() {
	}

	public Customer(Integer customerId, @NotBlank(message = "Email không được để trống") String customerEmail,
			@NotBlank(message = "Mật khẩu không được để trống") String customerPassword,
			@NotBlank(message = "Tên không được để trống") String customerName,
				boolean sex,
			@NotBlank(message = "SĐT không được để trống") String customerPhone, String customerAddress,
			String createAt, boolean isLock) {
		this.customerId = customerId;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.sex = sex;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.createAt = createAt;
		this.isLock = isLock;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	

	public boolean isLock() {
		return isLock;
	}

	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}
	
	

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerEmail=" + customerEmail + ", customerPassword="
				+ customerPassword + ", customerName=" + customerName + ", sex=" + sex + ", customerPhone="
				+ customerPhone + ", customerAddress=" + customerAddress + ", createAt=" + createAt + "]";
	}
	
	
	
	
}
