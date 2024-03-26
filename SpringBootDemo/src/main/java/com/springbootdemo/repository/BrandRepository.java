package com.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootdemo.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
