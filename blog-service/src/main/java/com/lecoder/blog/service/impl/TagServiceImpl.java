package com.lecoder.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecoder.blog.dao.mapper.TagMapper;
import com.lecoder.blog.po.BlogTag;
import com.lecoder.blog.service.TagService;
import com.lecoder.blog.vo.ArticleTag;

@Service
public class TagServiceImpl implements TagService{
	
	@Autowired
	private TagMapper tagMapper;
	
	@Override
	public List<Integer> handleTags(Integer userId,String[] tagName) {
		List<Integer> tagIdList = new ArrayList<>();
		for(int i = 0; i < tagName.length; i++) {
			BlogTag tag = tagMapper.findTagByUserIdAndTagName(userId, tagName[i]);
			if (tag == null) {
				tag = new BlogTag();
				tag.setUserId(userId);
				tag.setTagName(tagName[i]);
				tagMapper.saveTag(tag);
				tagIdList.add(tag.getId());
			}else {
				tagIdList.add(tag.getId());
			}
		}
		return tagIdList;
	}

	@Override
	public List<ArticleTag> listUserTag(Integer userId) {
		List<BlogTag> blogTags = tagMapper.listUserTag(userId);
		List<ArticleTag> tagList = new ArrayList<>(blogTags.size());
		for (int i = 0; i < blogTags.size(); i++) {
			BlogTag blogTag = blogTags.get(i);
			ArticleTag tag = new ArticleTag(blogTag.getId(), userId, blogTag.getTagName());
			tagList.add(tag);
		}
		return tagList;
	}

}
