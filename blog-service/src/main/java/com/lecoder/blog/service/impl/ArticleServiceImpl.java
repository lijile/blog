package com.lecoder.blog.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecoder.blog.dao.mapper.ArticleContentMapper;
import com.lecoder.blog.dao.mapper.ArticleMapper;
import com.lecoder.blog.dao.mapper.ArticleTagMapper;
import com.lecoder.blog.dao.mapper.UserInfoMapper;
import com.lecoder.blog.po.BlogArticle;
import com.lecoder.blog.po.BlogArticleContent;
import com.lecoder.blog.po.BlogArticleTag;
import com.lecoder.blog.po.BlogUserInfo;
import com.lecoder.blog.service.ArticleService;
import com.lecoder.blog.solr.bean.ArticleSolr;
import com.lecoder.blog.solr.search.ArticleSearcher;
import com.lecoder.blog.vo.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private ArticleContentMapper articleContentMapper;
	
	@Autowired
	private ArticleTagMapper articleTagMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private ArticleSearcher articleSearcher;

	@Override
	public Integer saveArticle(String title, String summary,Integer userId, Integer categoryId, String extraUrl, String content, List<Integer> tagIdList) {
		BlogArticle article = new BlogArticle();
		article.setTitle(title);
		article.setSummary(summary);
		article.setUserId(userId);
		article.setCategoryId(categoryId);
		article.setExtraUrl(extraUrl);
		articleMapper.saveArticle(article);
		if (article.getId() > 0) {
			BlogArticleContent articleContent = new BlogArticleContent();
			articleContent.setArticleId(article.getId());
			articleContent.setArticleContent(content);
			articleContentMapper.saveArticleContent(articleContent);
		}
		for(int i = 0; i < tagIdList.size(); i++) {
			BlogArticleTag articleTag = new BlogArticleTag();
			articleTag.setArticleId(article.getId());
			articleTag.setTagId(tagIdList.get(i));
			articleTagMapper.saveArticleTag(articleTag);
		}
		BlogUserInfo userInfo = userInfoMapper.findUserInfoByUserId(userId);
		ArticleSolr articleSolr = new ArticleSolr(article.getId(), title, summary, userId, userInfo.getUsername(), new Date(), content);
		try {
			articleSearcher.save(articleSolr);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return article.getId();
	}

	@Override
	public List<Article> listUserArticle(String username, Integer page) {
		int offset = 10;
		int start = (page - 1) * offset;
		List<BlogArticle> blogArticles = articleMapper.listUserArticleLimit(username,start,offset);
		if (blogArticles == null) {
			return null;
		}
		List<Article> articles = new ArrayList<>(blogArticles.size());
		BlogUserInfo blogUserInfo = userInfoMapper.findUserInfoByUsername(username);
		for (int i = 0; i < blogArticles.size(); i++) {
			BlogArticle blogArticle = blogArticles.get(i);
			Article article = new Article(blogArticle.getId(), blogArticle.getTitle(), 
					blogArticle.getSummary(), blogArticle.getUserId(), username, blogUserInfo.getFullname(), blogArticle.getCategoryId(), 
					blogArticle.getExtraUrl(), null, 0, 0, blogArticle.getGmtCreate(), blogArticle.getGmtModified());
			articles.add(article);
		}
		return articles;
	}

	@Override
	public Article findArticleByUsernameAndId(String username, Integer id) {
		BlogArticle blogArticle = articleMapper.findArticleById(id);
		if (blogArticle == null) {
			return null;
		}
		BlogArticleContent blogArticleContent = articleContentMapper.findArticleContentByArticleId(id);
		if (blogArticleContent == null) {
			return null;
		}
		BlogUserInfo blogUserInfo = userInfoMapper.findUserInfoByUsername(username);
		Article result = new Article(blogArticle.getId(), blogArticle.getTitle(), 
				blogArticle.getSummary(), blogArticle.getUserId(), username, blogUserInfo.getFullname(), blogArticle.getCategoryId(), 
				blogArticle.getExtraUrl(),blogArticleContent.getArticleContent(),0,0,blogArticle.getGmtCreate(), blogArticle.getGmtModified());
		return result;
	}

	@Override
	public List<Article> listArticle(Integer lastId) {
		int offset = 5;
		List<BlogArticle> blogArticles = articleMapper.listArticleLimit(lastId,offset);
		if (blogArticles == null) {
			return null;
		}
		List<Article> articles = new ArrayList<>(blogArticles.size());
		for (int i = 0; i < blogArticles.size(); i++) {
			BlogArticle blogArticle = blogArticles.get(i);
			BlogUserInfo blogUserInfo = userInfoMapper.findUserInfoByUserId(blogArticle.getUserId());
			Article article = new Article(blogArticle.getId(), blogArticle.getTitle(), 
					blogArticle.getSummary(), blogArticle.getUserId(), blogUserInfo.getUsername(), blogUserInfo.getFullname(), blogArticle.getCategoryId(), 
					blogArticle.getExtraUrl(), null, 0, 0, blogArticle.getGmtCreate(), blogArticle.getGmtModified());
			articles.add(article);
		}
		return articles;
	}

	@Override
	public List<Article> searchArticle(String keywords, Integer page) {
		List<Article> articles = new ArrayList<>();
		try {
			List<ArticleSolr> articleSolrs = articleSearcher.search(keywords, (page-1) * 10, 10);
			for(ArticleSolr articleSolr : articleSolrs) {
				Article article = new Article(articleSolr.getId(), articleSolr.getTitle(), articleSolr.getSummary(), articleSolr.getUserId(), articleSolr.getUsername(), "", 0, "", "", 0, 0, articleSolr.getGmt_modified(), articleSolr.getGmt_modified());
				articles.add(article);
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return articles;
	}

}
