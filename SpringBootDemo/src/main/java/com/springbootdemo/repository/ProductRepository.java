package com.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootdemo.entity.Category;
import com.springbootdemo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query(value = "SELECT * FROM shoestores.tbl_product LIMIT ?1, ?2",
			nativeQuery = true)
	List<Product> getAllProductsPaging(Integer start, Integer size);
	
	@Query(value = "SELECT * FROM shoestores.tbl_product where category_id = ?3 LIMIT ?1, ?2",
			nativeQuery = true)
	List<Product> findProductsByCategoryPagination(Integer start, Integer size, Integer categoryId);
	
	List<Product> findByCategory(Category category);
	
	//List<Product> findByCategoryCategoryId(Integer CategoryId);
}
