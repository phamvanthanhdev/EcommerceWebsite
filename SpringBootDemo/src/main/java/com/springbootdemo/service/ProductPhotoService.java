package com.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.entity.Product;
import com.springbootdemo.entity.ProductPhoto;
import com.springbootdemo.repository.ProductPhotoRepository;

@Service
public class ProductPhotoService {
	@Autowired
	ProductPhotoRepository repository;
	
	public void save(ProductPhoto productPhoto) {
		repository.save(productPhoto);
	}
	
	public List<ProductPhoto> getAll() {
		List<ProductPhoto> productPhotos = repository.findAll();
		return productPhotos;
	}
	
	public ProductPhoto findById(int id) {
		ProductPhoto productPhoto = repository.findById(id).get();
		return productPhoto;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	public List<ProductPhoto> findPhotosByProduct(Product product){ 
		List<ProductPhoto> photos = repository.findByProduct(product);
		return photos;
	}
}
