package com.springbootdemo.admincontroller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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

import com.springbootdemo.entity.Category;
import com.springbootdemo.service.CategoryService;

import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;

@Controller
public class AdminHomeController {
	@Autowired
	ServletContext app;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/admin")
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("/admin/category/add")
	public String category_add(@ModelAttribute("category") Category category) {
		return "admin/category/add";
	}
	
	@PostMapping("/admin/category/add")
	public String save_category_add(@Validated @ModelAttribute("category") Category category, 
									BindingResult result,
									Model model, RedirectAttributes ra,
									@RequestParam("attach") MultipartFile attach) throws IllegalStateException, IOException{
		if(result.hasErrors() || attach.isEmpty()) {
			model.addAttribute("message", "Dữ liệu chưa hợp lệ! Vui lòng thử lại.");
			if( attach.isEmpty()) 
				model.addAttribute("messageFile", "Vui lòng tải lên hình ảnh!");
			return "admin/category/add";
		}else {
			category.setCreateAt(LocalDateTime.now().toString());
			category.setUpdateAt(LocalDateTime.now().toString());
			if(!attach.isEmpty()) {
				try {
					String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
					String fileName = date + attach.getOriginalFilename();
					category.setCategoryPhoto(fileName);
					String filePath = app.getRealPath("images/"+fileName);
					attach.transferTo(new File(filePath));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			categoryService.save(category);
			
			ra.addFlashAttribute("message", "Thêm thành công danh mục!");
			
			return "redirect:/admin/category/list";
		}
	}
	
	@GetMapping("/admin/category/list")
	public String category_list(Model model) {
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		return "admin/category/list";
	}
	
	@GetMapping("/admin/category/update/{id}")
	public String category_update(@PathVariable("id") int id,
									Model model) {
		Category category = categoryService.findById(id);
		model.addAttribute("category", category);
		model.addAttribute("categoryPhoto", category.getCategoryPhoto());
		return "admin/category/update";
	}
	
	@PostMapping("/admin/category/update")
	public String save_category_update(@Validated @ModelAttribute("category") Category category, 
									BindingResult result,
									Model model, RedirectAttributes ra,
									@RequestParam("attach") MultipartFile attach) throws IllegalStateException, IOException{
		if(result.hasErrors()) {
			model.addAttribute("message", "Dữ liệu chưa hợp lệ! Vui lòng thử lại.");
			return "admin/category/update";
		}else {
			// Tìm lại category cũ
			//Category cate = categoryService.findById(category.getCategoryId());
			category.setUpdateAt(LocalDateTime.now().toString());
			if(!attach.isEmpty()) {
				try {
					String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
					String fileName = date + attach.getOriginalFilename();
					category.setCategoryPhoto(fileName);
					String filePath = app.getRealPath("images/"+fileName);
					attach.transferTo(new File(filePath));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			categoryService.save(category);
			
			ra.addFlashAttribute("message", "Cập nhật thành công danh mục!");
			
			return "redirect:/admin/category/list";
		}
	}
	
	@GetMapping("/admin/category/delete/{id}")
	public String category_delete(@PathVariable("id") int id, RedirectAttributes ra) {
		
		categoryService.deleteById(id);

		ra.addFlashAttribute("message", "Xóa thành công danh mục!");
		
		return "redirect:/admin/category/list";
	}
}
