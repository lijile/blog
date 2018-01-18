package com.lecoder.blog.dao.mapper;

import java.util.List;

import com.lecoder.blog.po.BlogCategory;

public interface CategoryMapper {

	Integer saveCategory(BlogCategory blogCategory);

	List<BlogCategory> listCategory();

}
