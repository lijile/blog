package com.lecoder.blog.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lecoder.blog.po.BlogTag;

public interface TagMapper {

	int saveTag(BlogTag tag);
	
	BlogTag findTagByUserIdAndTagName(@Param("userId")int userId,@Param("tagName")String tagName);

	List<BlogTag> listUserTag(Integer userId);

}
