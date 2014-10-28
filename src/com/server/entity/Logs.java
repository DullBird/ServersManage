package com.server.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 日志实体
 * @author DullBird
 * @date 2014-7-3
 */
public class Logs {
	
	private int logId;				//id
	@NotEmpty
	private String trueName;		//操作人真实姓名
	@NotEmpty
	private String roleName;		//操作人角色
	private String log;				//日志
	private Date createDate;		//记录时间
	private String serverName;		//操作的服务器名

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}


}
