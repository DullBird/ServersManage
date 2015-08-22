package com.server.utils.listener;

import javax.annotation.Resource;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.server.user.service.IOnlineUserService;
import com.server.utils.ServiceFacade;

public class OnlineUserListener implements HttpSessionListener {
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		//System.out.println("创建sessionId："+event.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		//System.out.println("消除sessionId："+ event.getSession().getId());
		//从容器中获取业务逻辑类，清空该sessionId的在线用户map
		IOnlineUserService onlineUserService = ServiceFacade.getBean("user.service.OnlineUserService", IOnlineUserService.class);
		onlineUserService.delOnlineUser(event.getSession().getId());
	}

}
