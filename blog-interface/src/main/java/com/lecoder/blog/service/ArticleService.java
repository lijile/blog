package com.lecoder.blog.service;

import java.util.List;
import com.lecoder.blog.vo.Article;
import com.lecoder.common.web.Pager;

public interface ArticleService {

	Integer saveArticle(String title, String summary,Integer userId, Integer categoryId, String extraUrl, String content, List<Integer> tagIdList);

	List<Article> listUserArticle(String username,Integer page);
	
	Article findArticleByUsernameAndId(String username, Integer id);
	
	List<Article> listArticle(Integer lastId);

	List<Article> searchArticle(String keywords, Integer page);

	Pager listArticleWithPage(Integer page, Integer pageSize, Integer record);
}
