package com.mime.bbs.visitor.service;

import com.mime.bbs.model.SysUser;

public interface SysUserAuthenService {
	boolean userRegister(SysUser sysUser);
		
	boolean isExistUsername(String username);
	
	SysUser findSysUserByUsername(String username);
}
