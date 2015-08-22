package com.server.aop;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.server.base.StaticParam;
import com.server.user.service.IOnlineUserService;
import com.server.user.service.impl.OnlineUserService;
import com.server.utils.page.Pagination;
import com.server.vo.JsonResult;
import com.server.vo.user.UserVo;

/**
 * 用于记录和消除线上用户的aop
 * @author Dull Bird
 * @date 2015-8-19
 */

@Aspect
@Component
public class OnlineUserAop {
	
	@Resource(name = "user.service.OnlineUserService")
	private IOnlineUserService onlineUserService;
	
	/**
	 * 登录加入在线用户map
	 * @param point
	 */
	@AfterReturning(pointcut = "execution(* com.server.user.service.*.login(..))",
			returning = "returnValue")
	public void loginPointcut(JoinPoint point,Object returnValue){
		JsonResult res = (JsonResult) returnValue;
		if(res.isSuccess()){
			HttpSession session = (HttpSession) point.getArgs()[1];
			onlineUserService.addOnlineUser(session.getId(), UserVo.getSessionUser(session));
		}
	}
	
	/**
	 * 登出删除在线用户map
	 * @param point
	 */
	@After("execution(* com.server.user.service.*.logout(..))")
	public void logoutPointcut(JoinPoint point){
		HttpSession session = (HttpSession) point.getArgs()[0];
		onlineUserService.delOnlineUser(session.getId());
	}

}
