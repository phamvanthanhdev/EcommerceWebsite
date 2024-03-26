package com.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.entity.Order;
import com.springbootdemo.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository repository;
	
	public void save(Order Order) {
		repository.save(Order);
	}
	
	public List<Order> getAll() {
		List<Order> Orders = repository.findAll();
		return Orders;
	}
	
	public Order findById(int id) {
		Order Order = repository.findById(id).get();
		return Order;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
}
