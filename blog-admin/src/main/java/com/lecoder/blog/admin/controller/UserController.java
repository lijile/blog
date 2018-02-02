package com.lecoder.blog.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lecoder.blog.service.UserService;
import com.lecoder.blog.vo.User;
import com.lecoder.common.exception.UserException;
import com.lecoder.common.web.Pager;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/user/login");
		new String();
		String errorClassName = (String) request.getAttribute("shiroLoginFailure");
		if (UnknownAccountException.class.getName().equals(errorClassName)) {
			mav.addObject("error","用户不存在！");
		}else if(IncorrectCredentialsException.class.getName().equals(errorClassName)){
			mav.addObject("error","密码错误");
		}else if (errorClassName != null) {
			mav.addObject("error","未知错误:" + errorClassName);
		}
		return mav;
	}
	
	@RequestMapping("/doLogin.do")
	public void doLogin(String username,
			String password){
		System.out.println();
	}
	
	@RequestMapping("/list.do")
	public ModelAndView list(@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(required = false, defaultValue = "0") Integer record){
		ModelAndView mav = new ModelAndView("/user/list");
		Pager pager = userService.listUser(page,pageSize,record);
		mav.addObject("pager",pager);
		return mav;
	}
	
	@RequestMapping("/create.do")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("/user/create");
		
		return mav;
	}
	
	@RequestMapping("/doCreateUser.do")
	public ModelAndView doCreateUser(String username,
			String fullname,
			String cellphone,
			String password){
		ModelAndView mav = new ModelAndView("redirect:list.do");
		
		try {
			User user = userService.saveUser(username,fullname,cellphone,password);
		} catch (UserException e) {
			e.printStackTrace();
		}
		return mav;
	}

}
