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
import com.mime.bbs.model.SysUserinfo;
import com.mime.bbs.system.service.SysMemberService;
import com.mime.bbs.util.PageUtils;


@RestController
@RequestMapping("system")
/**
 * 用户会员管理模块
 */
public class SysMemberController {
	
	 // 实例化sysUserService
	@Resource(name = "SysMemberService")
	private SysMemberService SysMemberService;
	
	/**
	 * 查询用户信息
	 */
	@GetMapping("members")
	public PageInfo<SysUserinfo> membersList(Model model,PageUtils page) {
		System.out.println("SysUser.viewUserShow()  进入管理用户查询界面");
		PageHelper.startPage(page.getPageNum(), page.getPageSize(),"u.id desc");
		List<SysUserinfo> userList = SysMemberService.findSysUserinfoByRole(2);
		////5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
		PageInfo<SysUserinfo> pageinfo = new PageInfo<>(userList,5);
		return pageinfo;
	}
	
	@RequestMapping("memberList")
	public ModelAndView memberList() {
		System.out.println("ManagerController.memberList()  进入用户查询列表");
		return new ModelAndView("system/member-list");
	}
	
}
