package com.springbootdemo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbootdemo.entity.Customer;
import com.springbootdemo.service.CookieService;
import com.springbootdemo.service.CustomerService;
import com.springbootdemo.service.SessionService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	CookieService cookieService;
	
	@GetMapping("/login")
	public String login_show(Model model) {
		String email = cookieService.getValue("email");
		String password = cookieService.getValue("password");
		if(email != null && password != null) {
			model.addAttribute("email", email);
			model.addAttribute("password", password);
		}
		return "user/login";
	}
	
	@GetMapping("/signup")
	public String signup_show(@ModelAttribute("customer") Customer customer) {
		return "user/signup";
	}
	
	@GetMapping("/logout")
	public String logout() {
		sessionService.remove("user");
		return "redirect:/login";
	}
	
	@PostMapping("/signup")
	public String signup_save(@ModelAttribute("customer") Customer customer, Model model) {
		customer.setCreateAt(LocalDateTime.now().toString());
		customer.setLock(true);
		
		customerService.save(customer);
		
		model.addAttribute("message", "Tạo tài khoản thành công!");
		
		return "user/signup";
	}
	
	@PostMapping("/login")
	public String login_save(@RequestParam("email") String email,
							@RequestParam("password") String password,
							@RequestParam("remember") boolean remember,
							RedirectAttributes ra) {
		if(email.equals("") || password.equals("")) {
			ra.addFlashAttribute("message", "Vui lòng nhập đầy đủ!");
			ra.addFlashAttribute("email", email);
			ra.addFlashAttribute("password", password);
			return "redirect:/login";
		}
		List<Customer> customers = customerService.findByCustomerEmailPassword(email, password);
		if(customers.size() < 1) {
			ra.addFlashAttribute("message", "Thông tin tài khoản, mật khẩu không chính xác!");
			ra.addFlashAttribute("email", email);
			ra.addFlashAttribute("password", password);
			return "redirect:/login";
		}
		
		for (Customer customer : customers) {
			sessionService.set("user", customer);
			if(remember) {
				cookieService.add("email", email, 1);
				cookieService.add("password", password, 1);
			}
			break;
		}
		
		/*String path = sessionService.get("back-url");
		if(path!=null) {
			return "redirect:/"+path;
		}*/
		
		return "redirect:/";
	}
}
