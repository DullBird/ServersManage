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
 * 判断登录的角色是否管理员的拦截器
 * @author DullBird
 * @date 2015-8-24
 * 
 */
public class AdminInterceptor implements HandlerInterceptor{

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
		UserVo sessionUser = StaticParam.ONLINE_USER_MAP.get(request.getSession().getId());
		if(!sessionUser.getrId().equals(1l)){
			//不是管理员，返回没有权限页面
			response.sendRedirect(request.getContextPath() + "/noPermission");
			return false;
		}
		return true;
	}
	
}
