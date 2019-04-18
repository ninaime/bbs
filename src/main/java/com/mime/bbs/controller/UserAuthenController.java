package com.mime.bbs.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mime.bbs.exception.CustomException;
import com.mime.bbs.model.SysUser;
import com.mime.bbs.service.UserAuthenService;
import com.mime.bbs.shiro.ShiroUtils;

//用户验证页面
@RestController
public class UserAuthenController {
	
	// 实例化sysUserService
	@Resource(name = "userAuthenService")
	private UserAuthenService userAuthenService;

	/**
	 * existsUsername判断用户名是否存在
	 */
	@RequestMapping("exists/username")
	@ResponseBody
	public String existsUsername(String username) {
		System.err.println("ExistsController.existsUsername  参数：" + username);
		// 判断注册是否合法
		if (userAuthenService.isExistUsername(username)) {
			return "1";// 查询为空表示用户名可以使用
		}
		return "0";
	}

		/**
		 * @throws CustomException
		 * @Validated：用于修饰需要被效验的参数 BindingResult：用于保存效验不通过的错误信息
		 * @Validated与BindingResult一定一前一后结合使用
		 */
		@RequestMapping("register")
		public ModelAndView userRegister(ModelAndView mav, @Validated SysUser sysUser, BindingResult bindingResult)
				throws CustomException {
			System.out.println(sysUser.toString());
			// 判断注册是否合法
//			if (bindingResult.hasErrors()) {
//				List<ObjectError> errors = bindingResult.getAllErrors();
//				for (ObjectError objectError : errors) {
//					System.out.println(objectError.getDefaultMessage());
//				}
//				mav.addObject("tourist/errors", errors);
//				// 如果注册失败返回注册界面
//				mav.setViewName("tourist/register");
//				return mav;
//			}
			// 1.1 将密码进行MD5加密
			String encryptPassword = ShiroUtils.MD5(sysUser.getUsername(), sysUser.getPassword());
			sysUser.setPassword(encryptPassword);
			System.out.println("加密后的密码为：" + sysUser.getPassword());
			if (userAuthenService.userRegister(sysUser)) {
				// 如果注册成功跳转到登录界面
				mav.setViewName("visitor/login");
			} else {
				mav.setViewName("visitor/register");
			}
			return mav;
		}

	/**
	 * 用户登录
	 * 使用Shiro编写认证操作
	 */
	@PostMapping(value = { "login/{url}" }) // 修饰方法
	public ModelAndView sysUserLogin(ModelAndView mav, String username, String password,@PathVariable("url")String url) throws CustomException {
		System.out.println("SysUserAuthenController.sysUserLogin()  进入登录验证"+url);

		// Subject：用户主体（把操作交给SecurityManager 安全管理器）
		Subject subject = SecurityUtils.getSubject();
			
		// 1.1 将密码进行MD5加密
		String encrypt = ShiroUtils.MD5(username, password);
			
		// 2.封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(username,encrypt);
			
		//是否记住我
		//token.setRememberMe(true);
			
		//3.执行登录方法
		try {
			subject.login(token);
			//登录成功
			System.out.println("登录成功");
			Session session = subject.getSession();
			SysUser user = (SysUser)subject.getPrincipal();
			session.setAttribute( "user",user);
			switch (user.getRole().getId()) {
			case 1:
				mav.setViewName( "redirect:/system/");
				break;
			default:
				mav.setViewName( "redirect:/");
				break;
			}
		} catch (AuthenticationException e) {
			//登录失败：用户名不存在
			mav.addObject("message", "用户名或密码错误");
			mav.setViewName( "/visitor/"+url);
		}
		return mav;
	}
	

	//页面跳转到登录界面
	@RequestMapping(value="sign-in",method=RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("sign-in");
	}

	//页面跳转到注册界面
	@RequestMapping(value="sign-up",method=RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("sign-up");
	}
}
