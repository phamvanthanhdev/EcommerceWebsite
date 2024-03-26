package com.springbootdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootdemo.entity.Category;
import com.springbootdemo.entity.Product;
import com.springbootdemo.paging.Paging;
import com.springbootdemo.service.CategoryService;
import com.springbootdemo.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@ModelAttribute("colors")
	public List<String> colorsModel(){
		List<String> colors=new ArrayList<String>();  
		colors.add("White");
		colors.add("Black");
		colors.add("Blue");
		colors.add("Green");
		colors.add("Yellow");
		return colors;
	}
	
	@ModelAttribute("sizes")
	public List<String> sizesModel(){
		List<String> sizes=new ArrayList<String>();  
		sizes.add("XS");
		sizes.add("S");
		sizes.add("M");
		sizes.add("L");
		sizes.add("XL");
		return sizes;
	}
	
	@GetMapping("/shop")
	public String product_show(@RequestParam("page") int page, Model model) {
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);

		Paging paging = new Paging();
		paging.setPageCurrent(page);
		paging.setPageSize(3);
		
		paging = productService.findAllPagination(paging);
		model.addAttribute("paging", paging);
		
		return "user/shop";
	}
	
	@GetMapping("/productsByCategory/{categoryId}")
	public String product_by_category(@PathVariable("categoryId") int categoryId, 
								Model model,
								@RequestParam("page") int page) {
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		
		Category category = categoryService.findById(categoryId);

		Paging paging = new Paging();
		paging.setPageCurrent(page);
		paging.setPageSize(3);
		
		
		paging = productService.findProductsByCategoryPagination(paging, category);
		model.addAttribute("paging", paging);
		
		model.addAttribute("category", category);
		
		return "user/productbycategory";
	}
	
	///productDetails/${pro.productId}
	@GetMapping("productDetails/{id}")
	public String product_details_show(@PathVariable("id") int id, 
								Model model) {
		
		Product product = productService.findById(id);
		model.addAttribute("pro", product);
		
		List<Product> relatedProducts = productService.getByCategory(product.getCategory()); 
		model.addAttribute("relatedProducts", relatedProducts);
		
		return "user/productdetails";
	}
	
}




