package com.mime.bbs.shiro;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.mime.bbs.model.SysUser;
import com.mime.bbs.visitor.service.SysUserAuthenService;


/**
 * 实现AuthorizingRealm接口用户用户认证
 *	shiro连接数据的桥梁
 */
public class ShiroRealm extends AuthorizingRealm{
	
	// 实例化SysUserAuthenService
	@Resource(name = "sysUserAuthenService") 
	private SysUserAuthenService sysUserAuthenService;


	/**
	 *  执行认证逻辑
	 *  用户认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		//加这一步的目的是在Post请求的时候会先进认证，然后在到请求
		System.out.println("ShiroRealm.doGetAuthenticationInfo()  执行认证逻辑");
		
		// 编写shiro判断逻辑，判断用户名和密码
		SysUser sysUser = sysUserAuthenService.findSysUserByUsername(authenticationToken.getPrincipal().toString());
		
		if(sysUser==null) {
			System.out.println("用户名不存在");
			return null; //shiro底层会抛出UnknownAccountException异常
		}
		System.out.println("ShiroRealm.doGetAuthenticationInfo()  "+sysUser.toString());
		
		//1. principal：认证的实体信息，可以是username，也可以是数据表对应的用户的实体对象
		Object principal = sysUser;
		//2. hashedCredentials：密码
		Object hashedCredentials = sysUser.getPassword();
		//3. credentialsSalt：MD5盐值加密
		ByteSource credentialsSalt = ByteSource.Util.bytes(sysUser.getUsername());
		//4. realmName：当前realm对象的name，调用父类的getName()方法即可
		String realmName = getName();
		
		//根据用户的情况来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
		SimpleAuthenticationInfo simpleAuthenticationInfo = null;
		simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, hashedCredentials, credentialsSalt, realmName);
		return simpleAuthenticationInfo;
	}
	
	
	/**
	 * 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("ShiroRealm.doGetAuthorizationInfo()  执行授权逻辑");

		//1. 从PrincipalConllection中来获取登录用户的信息
		SysUser sysUser = (SysUser)principals.getPrimaryPrincipal();
		System.out.println("principal："+sysUser.toString());

		//2. 利用登录的用户信息来获取当前用户的角色或权限
		Set<String> roles = new HashSet<>();
		roles.add("user");
		if("admin".equals(sysUser.getRole().getRoleName())) {
			roles.add("admin");
		}
		
		//3. 创建SimpleAuthorizationInfo,并设置其role属性
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
		
		//添加资源的授权字符串
		//simpleAuthorizationInfo.addStringPermission(sysUser.getRole().getPermission());

		return simpleAuthorizationInfo;
	}
	
}
