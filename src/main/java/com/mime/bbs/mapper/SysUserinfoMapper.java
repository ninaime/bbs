package com.mime.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mime.bbs.model.SysUserinfo;

@Mapper
public interface SysUserinfoMapper {
	/**
	 * 通过权限查询返回所有用户和用户信息，不包括权限
	 * @return
	 */
	List<SysUserinfo> findSysUserinfoByRole(Integer roleId);
	
}
