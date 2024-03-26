package com.springbootdemo.cart;

import java.util.List;

public class Cart {
	private int cartId;
	private List<CartLine> cartLines;
	
	public Cart(int cartId, List<CartLine> cartLines) {
		this.cartId = cartId;
		this.cartLines = cartLines;
	}
	
	public Cart() {
	}
	
	public double totalPrice() {
		double sum = 0;
		for (CartLine cartLine : cartLines) {
			sum += cartLine.getProduct().getProductPrice() * (1 - cartLine.getProduct().getProductDiscount()) * cartLine.getCartQuantity();
		}
		return sum;
	}
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<CartLine> getCartLines() {
		return cartLines;
	}
	public void setCartLines(List<CartLine> cartLines) {
		this.cartLines = cartLines;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartLines=" + cartLines + "]";
	}
	
	
}
