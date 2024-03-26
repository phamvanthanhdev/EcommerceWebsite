package com.springbootdemo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbootdemo.cart.Cart;
import com.springbootdemo.cart.CartLine;
import com.springbootdemo.entity.Customer;
import com.springbootdemo.entity.Order;
import com.springbootdemo.entity.OrderDetail;
import com.springbootdemo.entity.Product;
import com.springbootdemo.service.OrderDetailService;
import com.springbootdemo.service.OrderService;
import com.springbootdemo.service.SessionService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@GetMapping("/order/checkout")
	public String show_checkout(@ModelAttribute("order") Order order,
								RedirectAttributes ra,
								Model model){
		Cart cart = sessionService.get("cart");
		if(cart == null) {
			ra.addFlashAttribute("message", "Chưa có sản phẩm nào trong giỏ hàng");
			return "redirect:/cart";
		}
		
		List<CartLine> cartLines = cart.getCartLines();
		
		if(cartLines.size() <= 0) {
			ra.addFlashAttribute("message", "Chưa có sản phẩm nào trong giỏ hàng");
			return "redirect:/cart";
		}
		
		model.addAttribute("cart", cart);
		
		return "user/checkout";
	}
	
	@PostMapping("/order/checkout")
	public String save_checkout(@ModelAttribute("order") Order order,
								Model model,
								RedirectAttributes ra){

		Cart cart = sessionService.get("cart");
		if(cart == null) {
			ra.addFlashAttribute("message", "Chưa có sản phẩm nào trong giỏ hàng");
			return "redirect:/cart";
		}
		
		List<CartLine> cartLines = cart.getCartLines();
		
		if(cartLines.size() <= 0) {
			ra.addFlashAttribute("message", "Chưa có sản phẩm nào trong giỏ hàng");
			return "redirect:/cart";
		}
		
		Customer customer = sessionService.get("user");
		order.setCustomer(customer);
		order.setCreateAt(LocalDateTime.now().toString());
		order.setOrderStatus(1);
		
		System.out.println("1 :" +order.toString());
		
		orderService.save(order);
		
		System.out.println(order.toString());
		
		//List<CartLine> cartLines = cart.getCartLines();
		
		List<OrderDetail> orderDetails = new ArrayList<>();
		
		for (CartLine cartLine : cartLines) {
			OrderDetail detail = new OrderDetail();
			detail.setOrder(order);
			detail.setProduct(cartLine.getProduct());
			detail.setQuantity(cartLine.getCartQuantity());
			detail.setColor(cartLine.getCartColor());
			detail.setSize(cartLine.getCartSize());
			orderDetailService.save(detail);
		}
		
		order.setOrderDetails(orderDetails);
		orderService.save(order);
		
		System.out.println(order.toString());
		
		cartLines.clear();
		cart.setCartLines(cartLines);
		
		ra.addFlashAttribute("message", "Đặt hàng thành công!");
		
		return "redirect:/cart";
	}
}
