package com.mime.bbs.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("system")
public class SysManageController {
	
	/**
	 * 视图页面跳转部分
	 * 进入后台管理
	 */
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("system/index");
	}
	
	//跳转到后台首页
	@RequestMapping(value="welcome",method=RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("welcome");
	}
}
