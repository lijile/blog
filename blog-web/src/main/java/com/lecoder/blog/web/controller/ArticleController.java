package com.lecoder.blog.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lecoder.blog.service.ArticleService;
import com.lecoder.blog.service.CategoryService;
import com.lecoder.blog.service.TagService;
import com.lecoder.blog.vo.Article;
import com.lecoder.blog.vo.ArticleTag;
import com.lecoder.blog.vo.Category;
import com.lecoder.blog.vo.User;
import com.lecoder.blog.web.common.Constants;
import com.lecoder.blog.web.common.JsonResult;
import com.lecoder.common.utils.StringUtils;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 跳转至写文章界面
	 * @return
	 */
	@RequestMapping("/editor")
	public ModelAndView editor(){
		ModelAndView mav = new ModelAndView("/article/editor");
		return mav;
	}
	
	/**
	 * 查询用户的标签库
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/tag")
	public JsonResult listTag(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute(Constants.BLOG_USER);
		JsonResult result = new JsonResult();
		if (user == null) {
			result.setResult(JsonResult.REDIRECT);
			result.setErrorMsg("请先登录");
			return result;
		}
		List<ArticleTag> tagList = tagService.listUserTag(user.getId());
		result.setResult(JsonResult.SUCCESS);
		result.setInfo(tagList);
		return result;
	}
	
	/**
	 * 查询用户的标签库
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/search",method = RequestMethod.POST)
	public JsonResult search(String keywords,Integer page){
		JsonResult result = new JsonResult();
		if (page == null || page <= 0) {
			page = 1;
		}
		if (StringUtils.isNotEmpty(keywords)) {
			List<Article> articles = articleService.searchArticle(keywords, page);
			result.setResult(JsonResult.SUCCESS);
			result.setInfo(articles);
			return result;
		}
		return result;
	}
	
	/**
	 * 查询博客分类列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/category")
	public JsonResult listCategory(){
		JsonResult result = new JsonResult();
		List<Category> categoryList = categoryService.listCategory();
		result.setResult(JsonResult.SUCCESS);
		result.setInfo(categoryList);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/listArticle")
	public JsonResult listArticle(Integer lastId){
		JsonResult result = new JsonResult();
		if (lastId == null || lastId <= 0) {
			lastId = 0;
		}
		List<Article> articleList = articleService.listArticle(lastId);
		result.setResult(JsonResult.SUCCESS);
		result.setInfo(articleList);
		return result;
	}
	
	/**
	 * 创建博客的接口
	 * @param title 标题
	 * @param summary 概要
	 * @param categoryId 文章分类id
	 * @param extraUrl 更多文章链接
	 * @param tagName 标签
	 * @param content 内容
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping(value = "/createArticle" , method = RequestMethod.POST)
	public JsonResult createArticle(String title,
			String summary,
			Integer categoryId,
			String extraUrl,
			@RequestParam("tagName[]") String[] tagName,
			String content,
			HttpServletRequest request){
		JsonResult result = new JsonResult();
		if (StringUtils.isEmpty(title)) {
			result.setErrorMsg("标题不能为空");
			return result;
		}
		if (StringUtils.isEmpty(summary)) {
			result.setErrorMsg("概要不能为空");
			return result;
		}
		if (categoryId == null || categoryId == 0) {
			result.setErrorMsg("文章分类不能为空");
			return result;
		}
		if (tagName == null || tagName.length == 0) {
			result.setErrorMsg("文章标签不能为空");
			return result;
		}
		if (StringUtils.isEmpty(content)) {
			result.setErrorMsg("内容不能为空");
			return result;
		}
		User user = (User) request.getSession().getAttribute(Constants.BLOG_USER);
		if (user == null) {
			result.setErrorMsg("请先登录");
			return result;
		}
		List<Integer> tagIdList = tagService.handleTags(user.getId(),tagName);
		if (tagIdList == null || tagIdList.size() == 0) {
			result.setErrorMsg("标签保存失败");
			return result;
		}
		Integer articleId = articleService.saveArticle(title,summary,user.getId(),categoryId,extraUrl,content,tagIdList);
		result.setResult(JsonResult.SUCCESS);
		result.setInfo(articleId);
		result.setMsg("文章保存成功");
		return result;
	}

}
