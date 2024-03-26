package com.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.entity.Customer;
import com.springbootdemo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository repository;
	
	public void save(Customer Customer) {
		repository.save(Customer);
	}
	
	public List<Customer> getAll() {
		List<Customer> Customers = repository.findAll();
		return Customers;
	}
	
	public Customer findById(int id) {
		Customer Customer = repository.findById(id).get();
		return Customer;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	public List<Customer> findByCustomerEmailPassword(String email, String pw) {
		List<Customer> customers = repository.findByCustomerEmailAndCustomerPassword(email, pw);
		return customers;
	}
}
