package com.mime.bbs.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/**
 * ShiroConfiguration shiro的配置类 用@Configuration 注解修饰表示它是一个配置类
 */
@Configuration
public class ShiroConfig {
	/**
	 * shiro的配置类需要创建三个方法 
	 * 1.创建ShiroFilterFactoryBean 
	 * 2.创建DefaultWebSecurityManager
	 * 3.创建Realm
	 */

	/**
	 * 1.创建ShiroFilterFactoryBean
	 */
	@Bean
	public ShiroFilterFactoryBean ShiroFilterFactoryBean(
			@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		System.out.println("ShiroConfiguration.getShiroFilterFactoryBean()  进入登录验证");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		// 设置未认证提示页面，进入登录页面
		shiroFilterFactoryBean.setLoginUrl("redirect:sign-in");

		// 设置未授权提示页面，进入错误页面
		shiroFilterFactoryBean.setUnauthorizedUrl("redirect:exception");

		// 登录成功后要跳转的链接
		//shiroFilterFactoryBean.setSuccessUrl("redirect:/system/");

		// 设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 使用shiro内置的过滤器实现页面拦截
		/**
		 * shiro内置过滤器可以实现权限相关的拦截器 
		 * anon：无需认证（登录）可以访问 
		 * authc：必须认证才可以访问
		 * user：如果使用remeberMe的功能可以直接访问 
		 * perms：该资源必须得到资源权限才可以访问 
		 * role：该资源必须得到角色权限才可以访问
		 */
		// 使用LinkedHashMap是为了保证拦截顺序
		Map<String, String> filterMap = new LinkedHashMap<String, String>();
		// 释放静态资源
		filterMap.put("/static/**", "anon");
		filterMap.put("/public/**", "anon");
		filterMap.put("/i18n/**", "anon");
		filterMap.put("/config/**", "anon");
		filterMap.put("/logout", "logout");
		// 个人区域需要认证
		//filterMap.put("/IdioUser/**", "authc");
		//filterMap.put("/user/**", "roles[user]");
		// 拦截管理员才能进入的权限
		filterMap.put("/system/**", "roles[admin]");

		//filterMap.put("/**", "authc");//全部拦截

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		System.out.println("Shiro拦截器工厂类注入成功");

		return shiroFilterFactoryBean;
	}

	/**
	 * 2.创建DefaultWebSecurityManager - 权限管理，配置主要是Realm的管理认证 -
	 * 使用@Qualifier("shiroRealm")拿到下面被Bean修饰的getRealm
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("shiroRealm") ShiroRealm realm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置realm
		securityManager.setRealm(realm);
		return securityManager;
	}

	/**
	 * 3.创建Realm
	 * 
	 * @Bean 相当于一个bean工厂 这句话和<bean id="lifecycleBeanPostProcessor" class=
	 *       "org.apache.shiro.spring.LifecycleBeanPostProcessor" />是同一作用 只要用@Bean
	 *       注解了，就表示是被spring管理起来的对象了
	 */
	@Bean(name = "shiroRealm")
	public ShiroRealm getRealm(@Qualifier("hashedCredentialsMatcher")HashedCredentialsMatcher hashedCredentialsMatcher) {
		ShiroRealm shiroRealm = new ShiroRealm();
		shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher);
		return new ShiroRealm();
	}

	/**
	 * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
	 * 所以我们需要修改下doGetAuthenticationInfo中的代码; ）
	 * MD5加密
	 */
	@Bean(name="hashedCredentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("MD5");// 散列算法:这里使用MD5算法;
		return hashedCredentialsMatcher;
	}

	/**
	 * 配置ShiroDialect，用于shiro与thyeleaf标签使用
	 */
	@Bean
	public ShiroDialect getShiroDialect() {
		return new ShiroDialect();
	}
}


//    /**
//     *  开启shiro aop注解支持.
//     *  使用代理方式;所以需要开启代码支持;
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
/*
 * Authentication：身份认证/登录，验证用户是不是拥有相应的身份；
 * Authorization：授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情，常见的如：验证某个用户是否拥有某个角色。
 * 或者细粒度的验证某个用户对某个资源是否具有某个权限； Session
 * Manager：会话管理，即用户登录后就是一次会话，在没有退出之前，它的所有信息都在会话中；会话可以是普通JavaSE环境的，也可以是如Web环境的；
 * Cryptography：加密，保护数据的安全性，如密码加密存储到数据库，而不是明文存储； Web
 * Support：Web支持，可以非常容易的集成到Web环境；
 * Caching：缓存，比如用户登录后，其用户信息、拥有的角色/权限不必每次去查，这样可以提高效率；
 * Concurrency：shiro支持多线程应用的并发验证，即如在一个线程中开启另一个线程，能把权限自动传播过去； Testing：提供测试支持； Run
 * As：允许一个用户假装为另一个用户（如果他们允许）的身份进行访问； Remember
 * Me：记住我，这个是非常常见的功能，即一次登录后，下次再来的话不用登录了。
 * 记住一点，Shiro不会去维护用户、维护权限；这些需要我们自己去设计/提供；然后通过相应的接口注入给Shiro即可。
 */
