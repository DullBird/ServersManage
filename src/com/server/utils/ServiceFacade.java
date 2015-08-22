package com.server.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/*******************************************************************************
 * 系统服务门面类
 * 
 * <pre>
 * 系统非注入service由此定义被调用
 * </pre>
 * 
 * @author zengxiangtao
 * @version 2013-07-01
 ******************************************************************************/
public class ServiceFacade {

	/**
	 * 从spring容器里获bean
	 * 
	 * @author zengxiangtao
	 * @param <T>
	 * */
	public static <T> T getBean(String beanName, Class<T> requiredType) {
		return ContextLoader.getCurrentWebApplicationContext().getBean(
				beanName, requiredType);
	}

	/**
	 * 从spring容器里获bean
	 * 
	 * @author zengxiangtao
	 * @param <T>
	 * */
	public static <T> T getBean(Class<T> requiredType) {
		return ContextLoader.getCurrentWebApplicationContext().getBean(
				requiredType);
	}
	
	/**
	 * 从容器中获取request对象，适用于非controller的情景
	 * @author Dull Bird
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	/**
	 * 从容器中获取session对象，适用于非controller的情景
	 * @author Dull Bird
	 * @return
	 */
	public static HttpSession getSession(){
		return getRequest().getSession();
	}
}
