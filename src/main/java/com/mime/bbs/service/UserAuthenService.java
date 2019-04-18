package com.mime.bbs.service;

import com.mime.bbs.model.SysUser;

public interface UserAuthenService {
	boolean userRegister(SysUser sysUser);
		
	boolean isExistUsername(String username);
	
	SysUser findSysUserByUsername(String username);
}
