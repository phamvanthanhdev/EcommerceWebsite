package com.springbootdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbootdemo.cart.Cart;
import com.springbootdemo.cart.CartLine;
import com.springbootdemo.service.CookieService;
import com.springbootdemo.service.ProductService;
import com.springbootdemo.service.SessionService;


@Controller
public class CartController {
	//private Cart cart = new Cart();
	
	@Autowired
	ProductService productService;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	CookieService cookieService;
	
	@GetMapping("/cart")
	public String show_cart(Model model){
		Cart cart = sessionService.get("cart");
		if(cart == null) cart = new Cart();
		
		List<CartLine> cartLines = cart.getCartLines();
		if(cartLines == null) cartLines = new ArrayList<CartLine>();
		
		cart.setCartLines(cartLines);
		
		model.addAttribute("cart", cart);
		
		return "user/cart";
	}
	
	@PostMapping("/cart/add")
	public String cart_add(@RequestParam("productId")int productId,
								@RequestParam("color")String color,
								@RequestParam("size")String size,
								@RequestParam("quantity")int quantity,
								Model model){

		Cart cart = sessionService.get("cart");
		if(cart == null) cart = new Cart();
		
		List<CartLine> cartLines = cart.getCartLines();
		if(cartLines == null) cartLines = new ArrayList<CartLine>();
		
		CartLine line = null;
		
		for (CartLine cartLine : cartLines) {
			if(cartLine.getProduct().getProductId() == productId 
					&& cartLine.getCartColor().equals(color)
					&& cartLine.getCartSize().equals(size)) {
				cartLine.setCartQuantity(cartLine.getCartQuantity() + quantity);
				line = cartLine;
			}
		}
		if(line == null) {
			line = new CartLine();
			line.setProduct(productService.findById(productId));
			line.setCartColor(color);
			line.setCartSize(size);
			line.setCartQuantity(quantity);
			
			cartLines.add(line);
		}
		
		cart.setCartLines(cartLines);
		
		sessionService.set("cart", cart);
		
		model.addAttribute("cart", cart);
		
		return "redirect:/cart";
	}
	
	@GetMapping("/cart/decreaseQuantity/{id}")
	public String decrease_quantity(@PathVariable("id")int productId,
								Model model,
								RedirectAttributes ra){

		Cart cart = sessionService.get("cart");
		List<CartLine> cartLines = cart.getCartLines();
		
		
		for (CartLine cartLine : cartLines) {
			if(cartLine.getProduct().getProductId() == productId) {
				cartLine.setCartQuantity(cartLine.getCartQuantity() - 1);
			}
		}
		
		cart.setCartLines(cartLines);
		
		sessionService.set("cart", cart);
		
		model.addAttribute("cart", cart);
		
		ra.addFlashAttribute("message", "Cập nhật số lượng thành công");
		
		return "redirect:/cart";
	}
	
	@GetMapping("/cart/increaseQuantity/{id}")
	public String increase_quantity(@PathVariable("id")int productId,
								Model model,
								RedirectAttributes ra){

		Cart cart = sessionService.get("cart");
		List<CartLine> cartLines = cart.getCartLines();
		
		
		for (CartLine cartLine : cartLines) {
			if(cartLine.getProduct().getProductId() == productId) {
				cartLine.setCartQuantity(cartLine.getCartQuantity() + 1);
			}
		}
		
		cart.setCartLines(cartLines);
		
		sessionService.set("cart", cart);
		
		model.addAttribute("cart", cart);
		
		ra.addFlashAttribute("message", "Cập nhật số lượng thành công");
		
		return "redirect:/cart";
	}
	
	@GetMapping("/cart/deleteLine/{id}")
	public String delete_line(@PathVariable("id")int productId,
								Model model,
								RedirectAttributes ra){

		Cart cart = sessionService.get("cart");
		List<CartLine> cartLines = cart.getCartLines();
		
		
		for (CartLine cartLine : cartLines) {
			if(cartLine.getProduct().getProductId() == productId) {
				cartLines.remove(cartLine);
				break;
			}
		}
		
		cart.setCartLines(cartLines);
		
		sessionService.set("cart", cart);
		
		model.addAttribute("cart", cart);
		
		ra.addFlashAttribute("message", "Xóa sản phẩm khỏi giỏ hàng thành công");
		
		return "redirect:/cart";
	}
	
}
