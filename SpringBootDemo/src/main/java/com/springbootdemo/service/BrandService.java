package com.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.entity.Brand;
import com.springbootdemo.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired
	BrandRepository repository;
	
	public void save(Brand brand) {
		repository.save(brand);
	}
	
	public List<Brand> getAll() {
		List<Brand> brands = repository.findAll();
		return brands;
	}
	
	public Brand findById(int id) {
		Brand brand = repository.findById(id).get();
		return brand;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
}
