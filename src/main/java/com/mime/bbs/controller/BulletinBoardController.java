package com.mime.bbs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mime.bbs.dto.ArticleDto;
import com.mime.bbs.service.BulletinBoardService;
import com.mime.bbs.vo.ArticleVO;
import com.mime.bbs.vo.ResultVO;

//首页页面跳转
@RestController
public class BulletinBoardController {
	
	@Resource(name="bulletinBoardService")
	BulletinBoardService bulletinBoardService;
	//初始化页面动态数据
	@GetMapping("initbbs")
	public ResultVO<List<ArticleVO>> initbbs() {
		//从数据库中获取数据
		List<ArticleDto> articleDtoList = bulletinBoardService.findArticle();
		List<ArticleVO> articleVOList = new ArrayList<ArticleVO>();
		//装配需要的数据
		for (ArticleDto articleDto : articleDtoList) {
			ArticleVO articleVO = new ArticleVO();
			//复制数据，从参数1到参数2
			BeanUtils.copyProperties(articleDto, articleVO);
			articleVO.setCollect(articleDto.getCollect()!=null?true:false);
			articleVOList.add(articleVO);
		}
		
		//创建返回数据
		ResultVO<List<ArticleVO>> result = new ResultVO<List<ArticleVO>>();
		result.setData(articleVOList);
		result.setCode(0);
		result.setMsg("成功");
		return result;
	}
	
	//收藏/取消收藏
		@GetMapping("collect")
		public boolean collect(int id) {
			
			return true;
		}
	
	
	
	//页面跳转，设置首页
	@GetMapping("/")
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
