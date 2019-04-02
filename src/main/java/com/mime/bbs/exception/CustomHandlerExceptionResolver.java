package com.mime.bbs.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//1.处理异常
		CustomException customException=null;
		//已知错误
		if(ex instanceof CustomException) {
			customException = (CustomException)ex;
		}else {//未知错误
			customException = new CustomException("未知错误："+ex.getMessage());
		}
		//记录日志或发送邮件给管理员，降低耦合度
		//log(); sendEmail();
		//2.异常处理完成之后，跳转指定页面，并且显示错误信息
		ModelAndView mav = new ModelAndView();
		mav.addObject("exceptionMessage",customException.getMessage());
		mav.setViewName("common/exception");
		return mav;
	}

}
