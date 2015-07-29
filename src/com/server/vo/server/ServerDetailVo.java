package com.server.vo.server;

import java.util.List;

import com.server.entity.Database;
import com.server.entity.Proxy;
import com.server.entity.ServerDetail;
import com.server.entity.ServerType;
import com.server.entity.WebApp;
import com.server.vo.user.UserServerVo;

/**
 * 服务器vo
 * @author Dull Bird
 * @date 2015-7-13
 *
 */
public class ServerDetailVo extends ServerDetail {
	
	private String stName;						//服务器类型名字，多个以,分隔
	private List<UserServerVo> userServerList;	//可管理该服务器的用户
	private List<Proxy> proxyList; 				// 代理服务器列表
	private List<WebApp> webAppList; 			// 应用服务器列表
	private List<Database> dbList; 				// 数据库服务器列表
	private List<ServerType> serverTypeList;	//服务器所属的服务器类型
	
	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}
	
	public List<UserServerVo> getUserServerList() {
		return userServerList;
	}
	
	public void setUserServerList(List<UserServerVo> userServerList) {
		this.userServerList = userServerList;
	}

	public List<ServerType> getServerTypeList() {
		return serverTypeList;
	}

	public void setServerTypeList(List<ServerType> serverTypeList) {
		this.serverTypeList = serverTypeList;
	}

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
	
}
