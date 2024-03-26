package com.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.entity.OrderDetail;
import com.springbootdemo.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
	@Autowired
	OrderDetailRepository repository;
	
	public void save(OrderDetail OrderDetail) {
		repository.save(OrderDetail);
	}
	
	public List<OrderDetail> getAll() {
		List<OrderDetail> OrderDetails = repository.findAll();
		return OrderDetails;
	}
	
	public OrderDetail findById(int id) {
		OrderDetail OrderDetail = repository.findById(id).get();
		return OrderDetail;
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
}
