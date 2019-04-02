package com.mime.bbs.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mime.bbs.mapper.SysUserMapper;
import com.mime.bbs.mapper.SysUserinfoMapper;
import com.mime.bbs.model.SysUser;
import com.mime.bbs.model.SysUserinfo;
import com.mime.bbs.system.service.SysMemberService;

@Service("SysMemberService")
public class SysMemberServiceImpl implements SysMemberService {
	
	@Autowired
	SysUserMapper sysUserMapper;
	@Autowired
	SysUserinfoMapper sysUserinfoMapper;

	@Override
	public List<SysUserinfo> findSysUserinfoByRole(Integer roleId) {
		return sysUserinfoMapper.findSysUserinfoByRole(roleId);
	}
	/**
	 * 查询SysUser总条数
	 */
	public Integer sysUserCount() {
		return sysUserMapper.sysUserCount();
	}
	
	public List<SysUser> findSysUserAll(){
		return sysUserMapper.findSysUserAll();
	}
}
