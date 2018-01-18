package com.lecoder.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecoder.blog.dao.mapper.CategoryMapper;
import com.lecoder.blog.po.BlogCategory;
import com.lecoder.blog.service.CategoryService;
import com.lecoder.blog.vo.Category;
import com.lecoder.common.utils.UUIDUtils;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public Integer saveCategory(String categoryName) {
		String categoryCode = UUIDUtils.getUUID().substring(0, 10);
		BlogCategory blogCategory = new BlogCategory();
		blogCategory.setCategoryCode(categoryCode);
		blogCategory.setCategoryName(categoryName);
		Integer flag = categoryMapper.saveCategory(blogCategory);
		return flag;
	}

	@Override
	public List<Category> listCategory() {
		List<BlogCategory> categories = categoryMapper.listCategory();
		List<Category> categoryList = new ArrayList<>();
		for (int i = 0; i < categories.size(); i++) {
			BlogCategory blogCategory = categories.get(i);
			Category category = new Category(blogCategory.getId(), blogCategory.getCategoryCode(), blogCategory.getCategoryName());
			categoryList.add(category);
		}
		return categoryList;
	}

}
