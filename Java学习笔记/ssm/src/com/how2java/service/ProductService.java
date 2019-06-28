package com.how2java.service;

import java.util.List;
import java.util.Map;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

public interface ProductService {
	public void add(Product product);
	
	public void update(Product product);
	
	public void delete(Product product);
	
	public Product get(int id);

	public List<Product> list(Map m);

	public int total(Category category);
}
