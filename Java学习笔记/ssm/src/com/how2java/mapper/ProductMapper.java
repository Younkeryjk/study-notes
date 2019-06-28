package com.how2java.mapper;

import java.util.List;
import java.util.Map;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

public interface ProductMapper {
	
	public void add(Product product);
	
	public void update(Product product);
	
	public void delete(int id);
	
	public Product get(int id);

	public List<Product> list(Map m);

	public int total(Category category);
}
