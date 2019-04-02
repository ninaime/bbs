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
		System.out.println("ManagerController.index()  进入后台管理");
		return new ModelAndView("system/index");
	}
	
	@RequestMapping(value="welcome",method=RequestMethod.GET)
	public ModelAndView welcome() {
		System.out.println("ManagerController.welcome()  进入后台管理系统");
		return new ModelAndView("welcome");
	}
	
	
}
