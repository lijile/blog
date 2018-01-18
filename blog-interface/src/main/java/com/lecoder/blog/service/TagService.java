package com.lecoder.blog.service;

import java.util.List;

import com.lecoder.blog.vo.ArticleTag;

public interface TagService {

	List<Integer> handleTags(Integer userId,String[] tagName);
	
	List<ArticleTag> listUserTag(Integer userId);

}
