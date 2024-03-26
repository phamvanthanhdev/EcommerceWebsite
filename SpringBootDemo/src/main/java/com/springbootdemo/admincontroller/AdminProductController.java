package com.springbootdemo.admincontroller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbootdemo.entity.Brand;
import com.springbootdemo.entity.Category;
import com.springbootdemo.entity.Product;
import com.springbootdemo.entity.ProductPhoto;
import com.springbootdemo.service.BrandService;
import com.springbootdemo.service.CategoryService;
import com.springbootdemo.service.ProductPhotoService;
import com.springbootdemo.service.ProductService;

import jakarta.servlet.ServletContext;

@Controller
public class AdminProductController {
	@Autowired
	ServletContext app;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	ProductPhotoService photoService;
	
	@ModelAttribute("categories")
	public List<Category> getAllCategories(){
		List<Category> categories = categoryService.getAll();
		return categories;
	}
	
	@ModelAttribute("brands")
	public List<Brand> getAllBrands(){
		List<Brand> brands = brandService.getAll();
		return brands;
	}
	
	@GetMapping("/admin/product/add")
	public String product_add(@ModelAttribute("product") Product product) {
		
		return "admin/product/add";
	}
	
	@PostMapping("/admin/product/add")
	public String save_product_add(@Validated @ModelAttribute("product") Product product, 
									BindingResult result,
									Model model, RedirectAttributes ra,
									@RequestParam("attach") MultipartFile attach) throws IllegalStateException, IOException{
		if(result.hasErrors() || attach.isEmpty()) {
			model.addAttribute("message", "Dữ liệu chưa hợp lệ! Vui lòng thử lại.");
			if( attach.isEmpty()) 
				model.addAttribute("messageFile", "Vui lòng tải lên hình ảnh!");
			return "admin/product/add";
		}else {
			product.setCreateAt(LocalDateTime.now().toString());
			product.setUpdateAt(LocalDateTime.now().toString());
			if(!attach.isEmpty()) {
				try {
					String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
					String fileName = date + attach.getOriginalFilename();
					product.setProductPhoto(fileName);
					String filePath = app.getRealPath("images/"+fileName);
					attach.transferTo(new File(filePath));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			productService.save(product);
			
			ra.addFlashAttribute("message", "Thêm thành công sản phẩm!");
			
			return "redirect:/admin/product/list";
		}
	}
	
	@GetMapping("/admin/product/list")
	public String product_list(Model model) {
		List<Product> products = productService.getAll();
		model.addAttribute("products", products);
		return "admin/product/list";
	}
	
	@GetMapping("/admin/product/update/{id}")
	public String product_update(@PathVariable("id") int id,
									Model model) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		model.addAttribute("productPhoto", product.getProductPhoto());
		return "admin/product/update";
	}
	
	@PostMapping("/admin/product/update")
	public String save_product_update(@Validated @ModelAttribute("product") Product product, 
									BindingResult result,
									Model model, RedirectAttributes ra,
									@RequestParam("attach") MultipartFile attach) throws IllegalStateException, IOException{
		if(result.hasErrors()) {
			model.addAttribute("message", "Dữ liệu chưa hợp lệ! Vui lòng thử lại.");
			return "admin/product/update";
		}else {
			product.setUpdateAt(LocalDateTime.now().toString());
			if(!attach.isEmpty()) {
				try {
					String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
					String fileName = date + attach.getOriginalFilename();
					product.setProductPhoto(fileName);
					String filePath = app.getRealPath("images/"+fileName);
					attach.transferTo(new File(filePath));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			productService.save(product);
			
			ra.addFlashAttribute("message", "Cập nhật thành công sản phẩm!");
			
			return "redirect:/admin/product/list";
		}
	}
	@GetMapping("/admin/product/delete/{id}")
	public String product_delete(@PathVariable("id") int id, RedirectAttributes ra) {
		
		productService.deleteById(id);

		ra.addFlashAttribute("message", "Xóa thành công sản phẩm!");
		
		return "redirect:/admin/product/list";
	}
	
	@GetMapping("/admin/product/updateshow/{id}")
	public String product_update_show(@PathVariable("id") int id, RedirectAttributes ra) {
		Product product = productService.findById(id);
		product.setIsShow(!product.getIsShow());
		productService.save(product);

		ra.addFlashAttribute("message", "Cập nhật trạng thái sản phẩm thành công!");
		
		return "redirect:/admin/product/list";
	}
	
	@GetMapping("/admin/product/photo/{id}")
	public String product_photo(@PathVariable("id") int id, Model model,
								@ModelAttribute("photo") ProductPhoto photo) {
		Product product = productService.findById(id);
		List<ProductPhoto> photos = photoService.findPhotosByProduct(product);
		
		model.addAttribute("id", product.getProductId());
		model.addAttribute("photos", photos);
		return "/admin/product/listphoto";
	}
	
	@PostMapping("/admin/product/savephoto")
	public String save_photo_add(@Validated @ModelAttribute("photo") ProductPhoto photo, 
									Model model,
									@RequestParam("id") int id,
									RedirectAttributes ra,
									@RequestParam("attach") MultipartFile attach) throws IllegalStateException, IOException{
		if(attach.isEmpty()) {
			model.addAttribute("message", "Dữ liệu chưa hợp lệ! Vui lòng thử lại.");
			model.addAttribute("messageFile", "Vui lòng tải lên hình ảnh!");
			return "/admin/product/listphoto";
		}else {
			if(!attach.isEmpty()) {
				try {
					String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
					String fileName = date + attach.getOriginalFilename();
					photo.setPhotoUrl(fileName);
					String filePath = app.getRealPath("images/"+fileName);
					attach.transferTo(new File(filePath));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			Product product = productService.findById(id);
			photo.setProduct(product);
			
			photoService.save(photo);
			
			ra.addFlashAttribute("message", "Thêm thành công hình ảnh!");
			
			return "redirect:/admin/product/photo/"+id;
		}
	}
	
	@GetMapping("/admin/product/deletephoto/{id}")
	public String product_photo_delete(@PathVariable("id") int photoid, RedirectAttributes ra,
										@RequestParam("id") int id) {
		
		photoService.deleteById(photoid);

		ra.addFlashAttribute("message", "Xóa thành công hình ảnh!");
		
		return "redirect:/admin/product/photo/"+id;
	}
	
}
