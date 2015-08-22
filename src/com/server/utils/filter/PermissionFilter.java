package com.server.utils.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.utils.EncodeFilter;
import com.sun.xml.internal.bind.v2.runtime.output.Encoded;

/*******************************************************************************
 * 系统全局过滤器
 * 
 * <pre>
 * 系统权限;全局变量等过滤
 * </pre>
 * 
 * @author zengxiangtao
 * @version 2013-07-01
 ******************************************************************************/
public class PermissionFilter implements Filter {

	/**
	 * Filter初始化
	 * 
	 * @author zengxiangtao
	 * 
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

	/**
	 * 过滤逻辑设计
	 * 
	 * @author zengxiangtao
	 * 
	 */
	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) srequest;
		//HttpServletResponse response = (HttpServletResponse) sresponse;
		/*------项目路径----------*/
		String base = request.getContextPath();
		request.setAttribute("base", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+base);
		/*------执行链----------*/
		chain.doFilter(srequest, sresponse);
	}

	@Override
	public void destroy() {

	}
}