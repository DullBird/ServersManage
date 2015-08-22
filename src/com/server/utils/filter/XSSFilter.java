package com.server.utils.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 全局过滤器，过滤所有参数（含有特殊符号的转换）
 * @author Dull Bird
 * @date 2015-8-22
 *
 */
public class XSSFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) srequest;
		FilterXSSRequestWrap xssRequestWrap = new FilterXSSRequestWrap(request);
		//使用FilterXSSRequestWrap过滤参数
		chain.doFilter(xssRequestWrap, sresponse);
	}

	@Override
	public void destroy() {
		
	}

}
