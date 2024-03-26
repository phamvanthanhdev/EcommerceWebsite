package com.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.entity.Category;
import com.springbootdemo.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository repository;
	
	public void save(Category category) {
		repository.save(category);
	}
	
	public List<Category> getAll() {
		List<Category> categories = repository.findAll();
		return categories;
	}
	
	public Category findById(int id) {
		Category category = repository.findById(id).get();
		return category;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
}
