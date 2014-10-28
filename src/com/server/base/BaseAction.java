package com.server.base;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * action基类
 * @author DullBird
 *
 */ 
public class BaseAction {
	
	/**
	 * 得到WEB工程根路径
	 * 
	 * @author flatychen
	 * @date 2014-4-18
	 * @return
	 */
	protected final String getWebRootPath() {
		return getRequest().getServletContext().getRealPath("");
	}

	/**
	 * 得到request
	 * 
	 * @author flatychen
	 * @date 2014-4-28
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	}
	

	/**
	 * 取得HttpSession
	 * 通过spring的RequestContextHolder获得session
	 * @return
	 * @author YangChongdi
	 * @date 2014-5-7
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	
	/**
	 * 得到request属性
	 * 
	 * @author flatychen
	 * @date 2014-4-28
	 * @param attributeName
	 * @return
	 */
	protected Object getRequestAttribute(String attributeName) {
		return RequestContextHolder.currentRequestAttributes().getAttribute(attributeName,
				RequestAttributes.SCOPE_REQUEST);
	}

	/**
	 * 得到sesssion属性
	 * 
	 * @author flatychen
	 * @date 2014-4-28
	 * @param attributeName
	 * @return
	 */
	protected Object getSessionAttribute(String attributeName) {
		return RequestContextHolder.currentRequestAttributes().getAttribute(attributeName,
				RequestAttributes.SCOPE_SESSION);
	}


	/**
	 * 得到ServletContext
	 * @author flatychen
	 * @date 2014-4-28
	 * @param attributeName
	 * @return
	 */
	protected ServletContext getServletContext() {
		return this.getRequest().getServletContext();
	}
	
	
	/**
	 * 得到ServletContext属性
	 * @author flatychen
	 * @date 2014-4-28
	 * @param attributeName
	 * @return
	 */
	protected Object getServletContextAttritube(String attributeName) {
		return this.getRequest().getServletContext().getAttribute(attributeName);
	}

}
