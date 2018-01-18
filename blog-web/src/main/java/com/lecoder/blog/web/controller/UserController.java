package com.lecoder.blog.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lecoder.blog.service.UserService;
import com.lecoder.blog.vo.User;
import com.lecoder.blog.web.common.Constants;
import com.lecoder.common.exception.UserException;
import com.lecoder.common.utils.StringUtils;

/**
 * 关于用户的controller
 * @author lecoder
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/sign-in")
	public ModelAndView signIn(){
		ModelAndView mav = new ModelAndView("/user/sign-in");
		return mav;
	}
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping("/sign-out")
	public ModelAndView signOut(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("redirect:/");
		request.getSession().setAttribute(Constants.BLOG_USER, null);
		return mav;
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("/sign-up")
	public ModelAndView signUp(){
		ModelAndView mav = new ModelAndView("/user/sign-up");
		return mav;
	}
	
	/**
	 * 执行注册操作
	 * @param username 用户名
	 * @param password 密码
	 * @param confirmPassword 确认密码
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/do-sign-up",method=RequestMethod.POST)
	public ModelAndView doSignUp(String username,
			String password,
			String confirmPassword,
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/user/sign-up");
		if (StringUtils.isEmpty(username)) {
			mav.addObject("error","用户名不为空");
			return mav;
		}
		if (StringUtils.isEmpty(password) || StringUtils.isEmpty(confirmPassword)) {
			mav.addObject("error","密码不为空");
			return mav;
		}
		if (!password.equals(confirmPassword)) {
			mav.addObject("error","两次输入的密码不一致");
			return mav;
		}
		try {
			User user = userService.signUp(username,password);
			request.getSession().setAttribute(Constants.BLOG_USER, user);
			mav.setViewName("redirect:/"+username);
			return mav;
		} catch (UserException e) {
			mav.addObject("error",e.getMessage());
		}
		return mav;
	}
	
	/**
	 * 执行登录操作
	 * @param username 用户名
	 * @param password 密码
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/do-sign-in",method=RequestMethod.POST)
	public ModelAndView doSignIn(String username,
			String password,
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/user/sign-in");
		if (StringUtils.isEmpty(username)) {
			mav.addObject("error","用户名不为空");
			return mav;
		}
		if (StringUtils.isEmpty(password)) {
			mav.addObject("error","密码不为空");
			return mav;
		}
		try {
			User user = userService.signIn(username,password);
			request.getSession().setAttribute(Constants.BLOG_USER, user);
			mav.setViewName("redirect:/"+username);
			return mav;
		} catch (UserException e) {
			mav.addObject("error",e.getMessage());
		}
		return mav;
	}
	

}
