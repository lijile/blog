package com.lecoder.blog.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lecoder.blog.service.ArticleService;
import com.lecoder.blog.service.TagService;
import com.lecoder.blog.vo.Article;
import com.lecoder.common.utils.StringUtils;

/**
 * 个人主页的controller
 * @author lecoder
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 个人主页
	 * @param username 用户名
	 * @param page 页数
	 * @return
	 */
	@RequestMapping("/{username}")
	public ModelAndView list(@PathVariable("username") String username,Integer page){
		ModelAndView mav = new ModelAndView("/home/list");
		if (StringUtils.isEmpty(username)) {
			return mav;
		}
		if (page == null || page <= 0) {
			page = 1;
		}
		List<Article> articleList = articleService.listUserArticle(username, page);
		mav.addObject("articleList", articleList);
		mav.addObject("username",username);
		return mav;
	}
	
	/**
	 * 个人博文
	 * @param username 用户名
	 * @param id articleId
	 * @return
	 */
	@RequestMapping("/{username}/{id}")
	public ModelAndView item(@PathVariable() String username,
			@PathVariable("id") Integer id){
		ModelAndView mav = new ModelAndView("/home/view");
		if (StringUtils.isEmpty(username) || id == null) {
			return mav;
		}
		Article article = articleService.findArticleByUsernameAndId(username,id);
		if (article == null) {
			mav.setViewName("redirect:/"+username);
			return mav;
		}
		mav.addObject("article",article);
		mav.addObject("username",username);
		return mav;
	}

}
