package com.mime.bbs.system.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.mime.bbs.model.SysUserinfo;

public class SysMemberServiceTest {
	
	@Resource(name="sysMemberService")
	SysMemberService sysMemberService;
	
	@Test
	public void findSysUserinfoByRoleTest() {
		List<SysUserinfo> ulist = sysMemberService.findSysUserinfoByRole(2);
		for (SysUserinfo sysUserinfo : ulist) {
			System.out.println(sysUserinfo.toString());
		}
	}
}
