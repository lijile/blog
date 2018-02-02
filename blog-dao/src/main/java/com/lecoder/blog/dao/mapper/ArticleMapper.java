package com.lecoder.blog.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lecoder.blog.po.ArticleDetail;
import com.lecoder.blog.po.BlogArticle;

public interface ArticleMapper {

	int saveArticle(BlogArticle article);

	List<BlogArticle> listUserArticleLimit(@Param("username") String username,@Param("start") int start,@Param("offset") int offset);

	BlogArticle findArticleById(Integer id);

	List<BlogArticle> listArticleLimit(@Param("lastId") int lastId,@Param("offset") int offset);

	int queryForCount();

	List<ArticleDetail> listArticle(@Param("start") Integer start,@Param("offset") Integer offset);

}
