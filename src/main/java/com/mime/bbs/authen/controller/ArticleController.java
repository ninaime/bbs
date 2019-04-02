/**
 * 认证后的包
 */
package com.mime.bbs.authen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 文章类
 */
@RestController
@RequestMapping("authen")
public class ArticleController { 
	
	/**
	 * 发表文章页面跳转
	 */
	@RequestMapping(value="publishedArticle",method=RequestMethod.GET)
	public ModelAndView publish() {
		System.out.println("ArticleController.publishedArticle()  进入发表文章视图界面");
		return new ModelAndView("authen/publish-article");
	}
	
}
