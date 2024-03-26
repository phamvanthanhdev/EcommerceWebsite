package com.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springbootdemo.entity.Category;
import com.springbootdemo.service.CategoryService;

@Controller
public class HomeController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		return "user/home";
	}
	

}
