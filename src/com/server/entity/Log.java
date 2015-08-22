package com.server.entity;

import java.util.Date;

/**
 * 日志实体类
 * 
 * @author Dull Bird
 * @date 2015-8-17
 * 
 */
public class Log {

	private Long id;
	private Long createUid; 		// 操作人id
	private String createUser; 		// 操作人
	private String log; 			// 日志内容
	private Date createDate; 		// 日志生成时间
	private Long userId;			//目标用户id
	private String realName;		//目标用户
	private Long sId;				//目标服务器id
	private String sName;			//目标服务器
	private Long proxyId;			//代理服务器id
	private Long webAppId;			//应用服务器id
	private Long databaseId;		//数据库服务器id

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreateUid() {
		return createUid;
	}

	public void setCreateUid(Long createUid) {
		this.createUid = createUid;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getsId() {
		return sId;
	}

	public void setsId(Long sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Long getProxyId() {
		return proxyId;
	}

	public void setProxyId(Long proxyId) {
		this.proxyId = proxyId;
	}

	public Long getWebAppId() {
		return webAppId;
	}

	public void setWebAppId(Long webAppId) {
		this.webAppId = webAppId;
	}

	public Long getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(Long databaseId) {
		this.databaseId = databaseId;
	}
	
}
