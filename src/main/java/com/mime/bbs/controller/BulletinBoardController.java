package com.mime.bbs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mime.bbs.model.BbsArticle;
import com.mime.bbs.service.BulletinBoardService;

//首页页面跳转
@RestController
public class BulletinBoardController {
	
	@Resource(name="bulletinBoardService")
	BulletinBoardService bulletinBoardService;
	//初始化页面动态数据
	@GetMapping("initbbs")
	public List<BbsArticle> initbbs() {
		List<BbsArticle> articles = bulletinBoardService.findArticle();
		System.out.println(articles.get(0).toString());
		return articles;
	}
	
	
	//页面跳转，设置首页
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	//设置异常页面
	@RequestMapping(value="exception",method=RequestMethod.GET)
	public ModelAndView exception() {
		return new ModelAndView("visitor/exception");
	}
	
	//进入管理员登录页面
	@RequestMapping(value="admin",method=RequestMethod.GET)
	public ModelAndView admin() {
		return new ModelAndView("visitor/admin-login");
	}
}
