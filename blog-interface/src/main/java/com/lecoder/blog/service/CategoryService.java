package com.lecoder.blog.service;

import java.util.List;

import com.lecoder.blog.vo.Category;

public interface CategoryService {
	
	public Integer saveCategory(String categoryName);
	
	public List<Category> listCategory();

}
