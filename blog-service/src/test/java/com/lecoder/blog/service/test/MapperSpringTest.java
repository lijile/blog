package com.lecoder.blog.service.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.lecoder.blog.dao.mapper.ArticleContentMapper;
import com.lecoder.blog.dao.mapper.ArticleTagMapper;
import com.lecoder.blog.dao.mapper.TagMapper;
import com.lecoder.blog.dao.mapper.UserInfoMapper;
import com.lecoder.blog.dao.mapper.UserMapper;
import com.lecoder.blog.po.BlogArticle;
import com.lecoder.blog.po.BlogArticleContent;
import com.lecoder.blog.po.BlogArticleTag;
import com.lecoder.blog.po.BlogGender;
import com.lecoder.blog.po.BlogTag;
import com.lecoder.blog.po.BlogUser;
import com.lecoder.blog.po.BlogUserInfo;
import com.lecoder.blog.service.ArticleService;
import com.lecoder.blog.service.CategoryService;
import com.lecoder.blog.service.TagService;
import com.lecoder.blog.service.UserService;
import com.lecoder.blog.vo.Article;
import com.lecoder.blog.vo.ArticleTag;
import com.lecoder.blog.vo.Category;
import com.lecoder.blog.vo.User;
import com.lecoder.common.exception.UserException;
import com.lecoder.common.utils.PasswordUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml","classpath:applicationContext-solr.xml"})
public class MapperSpringTest {
	
	@Autowired
	private TagMapper tagMapper;
	
	@Autowired
	private ArticleContentMapper articleContentMapper;
	
	@Autowired
	private ArticleTagMapper articleTagMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private CategoryService categoryService;
	
//	@Test
//	public void testSaveTag(){
//		BlogTag tag = new BlogTag();
//		tag.setUserId(1);
//		tag.setTagName("测试");
//		tag.setGmtCreate(new Date());
//		int flag = tagMapper.saveTag(tag);
//	}
//	
//	@Test
//	public void testSaveArticleContent(){
//		BlogArticleContent articleContent = new BlogArticleContent();
//		articleContent.setArticleId(1);
//		articleContent.setArticleContent("test");
//		articleContentMapper.saveArticleContent(articleContent);
//	}
//	
//	@Test
//	public void testSaveArticleTag(){
//		BlogArticleTag articleTag = new BlogArticleTag();
//		articleTag.setArticleId(1);
//		articleTag.setTagId(2);
//		articleTagMapper.saveArticleTag(articleTag);
//	}
//	
//	@Test
//	public void testSignUp(){
//		try {
//			userService.signUp("lijile","123456");
//		} catch (UserException e) {
//			System.out.println(e.getCode());
//		}
//	}
	
	@Test
	public void test(){
		List<Integer> tagIdList = new ArrayList<>();
		tagIdList.add(50);
		articleService.saveArticle("article title", "article summary", 1, 1, "", "article content", tagIdList);
	}

}

