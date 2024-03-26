package com.springbootdemo.cart;

import com.springbootdemo.entity.Product;

public class CartLine {
	private Product product;
    private int cartQuantity;
    private String cartColor;
    private String cartSize;
    
	public CartLine() {
	}
	
	public CartLine(Product product, int cartQuantity, String cartColor, String cartSize) {
		this.product = product;
		this.cartQuantity = cartQuantity;
		this.cartColor = cartColor;
		this.cartSize = cartSize;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	public String getCartColor() {
		return cartColor;
	}
	public void setCartColor(String cartColor) {
		this.cartColor = cartColor;
	}
	public String getCartSize() {
		return cartSize;
	}
	public void setCartSize(String cartSize) {
		this.cartSize = cartSize;
	}
	@Override
	public String toString() {
		return "CartLine [product=" + product + ", cartQuantity=" + cartQuantity + ", cartColor=" + cartColor
				+ ", cartSize=" + cartSize + "]";
	}
    
    
}
