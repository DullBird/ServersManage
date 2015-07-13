package com.server.vo.server;

import java.util.List;

import com.server.entity.Database;
import com.server.entity.Proxy;
import com.server.entity.ServerDetail;
import com.server.entity.WebApp;
import com.server.vo.user.UserServerVo;

/**
 * 服务器实vo
 * @author Dull Bird
 * @date 2015-7-13
 *
 */
public class ServerDetailVo extends ServerDetail {
	
	private List<Proxy> proxyList;		//代理服务器列表
	private List<WebApp> webAppList;	//应用服务器列表
	private List<Database> dbList;		//数据库服务器列表
	private List<UserServerVo> userServerList;	//可管理该服务器的用户
	
	public List<Proxy> getProxyList() {
		return proxyList;
	}
	
	public void setProxyList(List<Proxy> proxyList) {
		this.proxyList = proxyList;
	}
	
	public List<WebApp> getWebAppList() {
		return webAppList;
	}
	
	public void setWebAppList(List<WebApp> webAppList) {
		this.webAppList = webAppList;
	}
	
	public List<Database> getDbList() {
		return dbList;
	}
	
	public void setDbList(List<Database> dbList) {
		this.dbList = dbList;
	}
	
	public List<UserServerVo> getUserServerList() {
		return userServerList;
	}
	
	public void setUserServerList(List<UserServerVo> userServerList) {
		this.userServerList = userServerList;
	}
	
}
