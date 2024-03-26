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
import com.springbootdemo.service.BrandService;

import jakarta.servlet.ServletContext;

@Controller
public class BrandController {
	@Autowired
	ServletContext app;
	
	@Autowired
	BrandService brandService;
	
	@GetMapping("/admin/brand/add")
	public String brand_add(@ModelAttribute("brand") Brand brand) {
		return "admin/brand/add";
	}
	
	@PostMapping("/admin/brand/add")
	public String save_brand_add(@Validated @ModelAttribute("brand") Brand brand, 
									BindingResult result,
									Model model, RedirectAttributes ra,
									@RequestParam("attach") MultipartFile attach) throws IllegalStateException, IOException{
		if(result.hasErrors() || attach.isEmpty()) {
			model.addAttribute("message", "Dữ liệu chưa hợp lệ! Vui lòng thử lại.");
			if( attach.isEmpty()) 
				model.addAttribute("messageFile", "Vui lòng tải lên hình ảnh!");
			return "admin/brand/add";
		}else {
			brand.setCreateAt(LocalDateTime.now().toString());
			brand.setUpdateAt(LocalDateTime.now().toString());
			if(!attach.isEmpty()) {
				try {
					String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
					String fileName = date + attach.getOriginalFilename();
					brand.setBrandPhoto(fileName);
					String filePath = app.getRealPath("images/"+fileName);
					attach.transferTo(new File(filePath));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			brandService.save(brand);
			
			ra.addFlashAttribute("message", "Thêm thành công thương hiệu!");
			
			return "redirect:/admin/brand/list";
		}
	}
	
	@GetMapping("/admin/brand/list")
	public String brand_list(Model model) {
		List<Brand> brands = brandService.getAll();
		model.addAttribute("brands", brands);
		return "admin/brand/list";
	}
	
	@GetMapping("/admin/brand/update/{id}")
	public String brand_update(@PathVariable("id") int id,
									Model model) {
		Brand brand = brandService.findById(id);
		model.addAttribute("brand", brand);
		model.addAttribute("brandPhoto", brand.getBrandPhoto());
		return "admin/brand/update";
	}
	
	@PostMapping("/admin/brand/update")
	public String save_brand_update(@Validated @ModelAttribute("brand") Brand brand, 
									BindingResult result,
									Model model, RedirectAttributes ra,
									@RequestParam("attach") MultipartFile attach) throws IllegalStateException, IOException{
		if(result.hasErrors()) {
			model.addAttribute("message", "Dữ liệu chưa hợp lệ! Vui lòng thử lại.");
			return "admin/brand/update";
		}else {
			// Tìm lại category cũ
			//Category cate = categoryService.findById(category.getCategoryId());
			brand.setUpdateAt(LocalDateTime.now().toString());
			if(!attach.isEmpty()) {
				try {
					String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
					String fileName = date + attach.getOriginalFilename();
					brand.setBrandPhoto(fileName);
					String filePath = app.getRealPath("images/"+fileName);
					attach.transferTo(new File(filePath));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			brandService.save(brand);
			
			ra.addFlashAttribute("message", "Cập nhật thành công thương hiệu!");
			
			return "redirect:/admin/brand/list";
		}
	}
	
	@GetMapping("/admin/brand/delete/{id}")
	public String brand_delete(@PathVariable("id") int id, RedirectAttributes ra) {
		
		brandService.deleteById(id);

		ra.addFlashAttribute("message", "Xóa thành công thương hiệu!");
		
		return "redirect:/admin/brand/list";
	}
}
