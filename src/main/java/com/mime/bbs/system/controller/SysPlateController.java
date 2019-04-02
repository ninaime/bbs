package com.mime.bbs.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mime.bbs.model.Plate;
import com.mime.bbs.system.service.SysPlateService;
import com.mime.bbs.util.PageUtils;

@RestController
@RequestMapping("system")
public class SysPlateController {
	
	@Resource(name="sysPlateService")
	SysPlateService sysPlateService;
	
	@GetMapping("plates")
	public PageInfo<Plate> membersList(Model model,PageUtils page) {
		System.out.println("SysUser.viewUserShow()  进入板块查询界面");
		PageHelper.startPage(page.getPageNum(), page.getPageSize(),"parent_id,sort");
		List<Plate> plateList = sysPlateService.findPlate();
		////5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
		PageInfo<Plate> pageinfo = new PageInfo<>(plateList,5);
		return pageinfo;
	}
	
	@RequestMapping("plateList")
	public ModelAndView plateList() {
		System.out.println("SysPlateController.plateList()  进入板块管理");
		return new ModelAndView("system/plate-list");
	}
	
	
}
