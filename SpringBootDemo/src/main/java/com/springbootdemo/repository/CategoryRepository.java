package com.springbootdemo.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdemo.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
