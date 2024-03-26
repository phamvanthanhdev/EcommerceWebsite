package com.springbootdemo.paging;

import java.util.List;

import com.springbootdemo.entity.Product;

public class Paging {
	//Tổng sản phẩm 1 trang
	private int pageSize;
	// Trang hiện tại
	private int pageCurrent;
	// Tổng tất cả sản phẩm
	private int pageCount;
	// Tổng số trang
	private int totalPage;
	//Danh sách sản phẩm
	private List<Product> products;
	
	public Paging(int pageSize, int pageCurrent, int pageCount, int totalPage, List<Product> products) {
		this.pageSize = pageSize;
		this.pageCurrent = pageCurrent;
		this.pageCount = pageCount;
		this.totalPage = totalPage;
		this.products = products;
	}

	public Paging() {}
	

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	
	
	
	
}
