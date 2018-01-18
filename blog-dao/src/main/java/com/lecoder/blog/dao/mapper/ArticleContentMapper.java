package com.lecoder.blog.dao.mapper;

import com.lecoder.blog.po.BlogArticleContent;

public interface ArticleContentMapper {

	int saveArticleContent(BlogArticleContent articleContent);

	BlogArticleContent findArticleContentByArticleId(Integer articleId);

}
