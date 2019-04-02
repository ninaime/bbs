package com.mime.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mime.bbs.model.SysUser;
import com.mime.bbs.util.PageUtils;
/**
 * 数据访问层（DAO）接口定义
 */
@Mapper
public interface SysUserMapper {
    
	/**
	 * 判断用户名是否存在
	 */
	Integer isExistUsername(String username);
	
	/**
	 * 通过用户名查询用户信息
	 */
	SysUser findSysUserByUsername(String username);
	
	
    Integer userRegister(SysUser sysUser);
    
    List<SysUser> showSysUser(PageUtils page);
        
    SysUser getSysUserById(int userId);
    /**
     * 查询sysuser的总条数
     */
    Integer sysUserCount();
    
    /**
     * 通过分页查询出sysuser
     */
    List<SysUser> findSysUserAll();
    
}