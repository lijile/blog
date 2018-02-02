package com.lecoder.blog.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lecoder.blog.service.ArticleService;
import com.lecoder.common.web.Pager;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/list.do")
	public ModelAndView list(@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(required = false, defaultValue = "0") Integer record){
		ModelAndView mav = new ModelAndView("/article/list");
		Pager pager = articleService.listArticleWithPage(page,pageSize,record);
		mav.addObject("pager",pager);
		return mav;
	}

}
