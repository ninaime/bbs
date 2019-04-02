package com.mime.bbs.visitor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BulletinBoardController {
	/**
	 * 设置首页
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView index() {
		System.out.println("BulletinBoardController.index()  进入首页");
		return new ModelAndView("visitor/index");
	}
	

	@RequestMapping(value="exception",method=RequestMethod.GET)
	public ModelAndView exception() {
		System.out.println("BulletinBoardController.exception()  进入异常界面");
		return new ModelAndView("visitor/exception");
	}
	
	@RequestMapping(value="admin",method=RequestMethod.GET)
	public ModelAndView admin() {
		System.out.println("BulletinBoardController.admin()  进入管理员登录界面");
		return new ModelAndView("visitor/admin-login");
	}
}
