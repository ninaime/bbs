package com.mime.bbs.system.service;

import java.util.List;

import com.mime.bbs.model.SysUser;
import com.mime.bbs.model.SysUserinfo;

public interface SysMemberService {
	
	
	/**
	 * 查询SysUser总条数
	 */
	Integer sysUserCount();
	
	List<SysUser> findSysUserAll();
	
	List<SysUserinfo> findSysUserinfoByRole(Integer roleId);
}
