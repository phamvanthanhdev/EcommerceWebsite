package com.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootdemo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	List<Customer> findByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);
}
