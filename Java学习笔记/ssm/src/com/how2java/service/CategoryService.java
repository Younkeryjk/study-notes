package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Category;
import com.how2java.util.Page;

public interface CategoryService {
	List<Category> list();
	
	List<Category> list(Page page);
	
	Category get(int id);
	
	int add(Category category);
	
	int update(Category category);
	
	void delete(int id);
	
	void addTwo();
	 
    void deleteAll();
    
    int total();
}
