package com.server.interceptors;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.server.base.StaticParam;
import com.server.vo.user.UserVo;

/**
 * 
 * 判断是否已经登录的拦截器
 * @author DullBird
 * @date 2015-7-17
 * 
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		/*
		 * 旧版本的登录
		 * UserVo sessionUser = (UserVo)request.getSession().getAttribute(StaticParam.SESSION_USER);
		if(null == sessionUser){
			//没有登录跳转到登录页面
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		return true;*/
		Map<String, UserVo> onlineUserMap = StaticParam.ONLINE_USER_MAP;
		if(null == onlineUserMap.get(request.getSession().getId())){
			//没有登录跳转到登录页面
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		return true;
	}
	
}
