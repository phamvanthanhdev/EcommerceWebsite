package com.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springbootdemo.entity.Category;
import com.springbootdemo.entity.Product;
import com.springbootdemo.paging.Paging;
import com.springbootdemo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;
	
	public void save(Product product) {
		repository.save(product);
	}
	
	public List<Product> getAll() {
		List<Product> products = repository.findAll();
		return products;
	}
	
	public Product findById(int id) {
		Product product = repository.findById(id).get();
		return product;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	public Paging findAllPagination(Paging paging){
        // Vị trí sản phẩm bắt đầu lấy trong danh sách
		int currentPosition = (paging.getPageCurrent()-1) * paging.getPageSize();
		//Số sản phẩm lấy
		int size = paging.getPageSize();
		//Pageable pageWithNumberRecords=
        //        PageRequest.of(currentPosition,size);

		
        //List<Product> products = repository.findAll(pageWithNumberRecords).getContent();
		
		List<Product> products = repository.getAllProductsPaging(currentPosition, size);

        //Integer totalElement = (int) repository.findAll(pageWithNumberRecords).getTotalElements();
        //int totalPages = repository.findAll(pageWithNumberRecords).getTotalPages();

		Integer totalElement = products.size();
		double pageDouble = repository.findAll().size() / size;
		int totalPages = (int) Math.ceil(pageDouble);
		
        System.out.println("Start : " + currentPosition);
        for (Product product : products) {
			System.out.println("Product : " + product.toString());
		}
        
        paging.setProducts(products);
        paging.setPageCount(totalElement);
        paging.setTotalPage(totalPages);
        return paging;
    }
	
	public Paging findProductsByCategoryPagination(Paging paging, Category category){
        // Vị trí sản phẩm bắt đầu lấy trong danh sách
		int currentPosition = (paging.getPageCurrent()-1) * paging.getPageSize();
		//Số sản phẩm lấy
		int size = paging.getPageSize();
		//Pageable pageWithNumberRecords=
        //        PageRequest.of(currentPosition,size);

		
        //List<Product> products = repository.findAll(pageWithNumberRecords).getContent();
		
		List<Product> products = repository.findProductsByCategoryPagination(currentPosition, size, category.getCategoryId());

        //Integer totalElement = (int) repository.findAll(pageWithNumberRecords).getTotalElements();
        //int totalPages = repository.findAll(pageWithNumberRecords).getTotalPages();

		Integer totalElement = products.size();
		double pageDouble = repository.findByCategory(category).size() / size;
		int totalPages = (int) Math.ceil(pageDouble);
		
        
        paging.setProducts(products);
        paging.setPageCount(totalElement);
        paging.setTotalPage(totalPages);
        return paging;
    }
	
	public List<Product> getByCategory(Category category) {
		List<Product> products = repository.findByCategory(category);
		return products;
	}

}
