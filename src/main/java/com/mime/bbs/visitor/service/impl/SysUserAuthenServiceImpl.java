package com.mime.bbs.visitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mime.bbs.mapper.SysUserMapper;
import com.mime.bbs.model.SysUser;
import com.mime.bbs.visitor.service.SysUserAuthenService;

@Service("sysUserAuthenService")
public class SysUserAuthenServiceImpl implements SysUserAuthenService{
	
	@Autowired
	SysUserMapper sysUserMapper;
	
	public boolean userRegister(SysUser sysUser) {
		if(sysUserMapper.userRegister(sysUser)>=0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isExistUsername(String username) {
		if(null==sysUserMapper.isExistUsername(username)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public SysUser findSysUserByUsername(String username) {
		return sysUserMapper.findSysUserByUsername(username);
	}
}
