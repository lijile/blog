package com.lecoder.blog.web.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lecoder.blog.dao.mapper.ArticleContentMapper;
import com.lecoder.blog.dao.mapper.ArticleTagMapper;
import com.lecoder.blog.dao.mapper.TagMapper;
import com.lecoder.blog.po.BlogArticleContent;
import com.lecoder.blog.po.BlogArticleTag;
import com.lecoder.blog.po.BlogTag;
import com.lecoder.blog.service.TagService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:service/applicationContext-dao.xml","classpath:service/applicationContext-service.xml"})
public class MapperTest {
	
	@Autowired
	private TagMapper tagMapper;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private ArticleContentMapper articleContentMapper;
	
	@Autowired
	private ArticleTagMapper articleTagMapper;
	
	@Test
	public void testSaveTag(){
		BlogTag tag = new BlogTag();
		tag.setUserId(1);
		tag.setTagName("测试");
		tag.setGmtCreate(new Date());
		int flag = tagMapper.saveTag(tag);
	}
	
	@Test
	public void testSaveArticleContent(){
		BlogArticleContent articleContent = new BlogArticleContent();
		articleContent.setArticleId(1);
		articleContent.setArticleContent("test");
		int contentId = articleContentMapper.saveArticleContent(articleContent);
		System.out.println(contentId);
	}
	
	@Test
	public void testSaveArticleTag(){
		BlogArticleTag articleTag = new BlogArticleTag();
		articleTag.setArticleId(1);
		articleTag.setTagId(63);
		articleTagMapper.saveArticleTag(articleTag);
	}

}