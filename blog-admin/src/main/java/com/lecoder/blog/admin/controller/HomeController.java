package com.lecoder.blog.admin.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lecoder.blog.service.MasterService;
import com.lecoder.blog.vo.ServerEnvironment;
import com.lecoder.common.web.JsonResult;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private MasterService masterService;
	
	@RequestMapping("/index.do")
	@RequiresRoles("admin")
	public ModelAndView home(){
		ModelAndView mav = new ModelAndView("/home/index");
		
		return mav;
	}
	
	
	@ResponseBody
	@RequestMapping("/getEnvInfo.do")
	public JsonResult getEnvInfo(){
		JsonResult result = new JsonResult();
		ServerEnvironment environment = masterService.getEnvironmentInfo();
		result.setResult(JsonResult.SUCCESS);
		result.setInfo(environment);
		return result;
	}

}
