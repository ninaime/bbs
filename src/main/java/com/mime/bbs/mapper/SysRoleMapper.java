package com.mime.bbs.mapper;

import com.mime.bbs.model.SysRole;
/**
 * 数据访问层（DAO）接口定义
 */
public interface SysRoleMapper {
	SysRole getRoleById(int roleId);
}