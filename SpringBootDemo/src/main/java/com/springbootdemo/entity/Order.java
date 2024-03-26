package com.springbootdemo.entity;

import java.util.List;

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
@Table(name = "tbl_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@NotBlank(message = "Tên khách hàng không được để trống")
	private String customerName;
	
	@NotBlank(message = "Địa chỉ giao không được để trống")
	private String customerAddress;
	
	@NotBlank(message = "SĐT khách hàng không được để trống")
	private String customerPhone;
	
	@NotNull
	private Integer orderStatus;
	
	@NotNull
	private String createAt;
	
	private String deliveryAt;
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Order() {
	}

	public Order(Integer orderId, @NotBlank(message = "Tên khách hàng không được để trống") String customerName,
			@NotBlank(message = "Địa chỉ giao không được để trống") String customerAddress,
			@NotBlank(message = "SĐT khách hàng không được để trống") String customerPhone,
			@NotNull Integer orderStatus, @NotNull String createAt, String deliveryAt, List<OrderDetail> orderDetails) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.orderStatus = orderStatus;
		this.createAt = createAt;
		this.deliveryAt = deliveryAt;
		this.orderDetails = orderDetails;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getDeliveryAt() {
		return deliveryAt;
	}

	public void setDeliveryAt(String deliveryAt) {
		this.deliveryAt = deliveryAt;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", customerAddress=" + customerAddress
				+ ", customerPhone=" + customerPhone + ", orderStatus=" + orderStatus + ", createAt=" + createAt
				+ ", deliveryAt=" + deliveryAt + ", orderDetails=" + orderDetails + ", customer=" + customer + "]";
	}
	
	
	
}
