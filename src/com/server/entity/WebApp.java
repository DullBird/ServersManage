package com.server.entity;

import java.util.Date;

/**
 * 应用服务器实体
 * 
 * @author DullBird
 * @date 2015-7-13
 */
public class WebApp {

	private Long id;					//主键
	private Long sId;					//服务器id
	private String appName;				//应用名
	private String appRoot;				//应用根路径
	private String appUrl;				//应用访问路径
	private String appDatasource;		//应用数据源，包括主机ip，端口，sid
	private String tomcatRoot;			//tomcat路径，包括路径，端口
	private Integer status;				//状态，1：显示 0：删除
	private Date createDate;			//创建时间
	private Long createUid;				//创建人id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getsId() {
		return sId;
	}

	public void setsId(Long sId) {
		this.sId = sId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppRoot() {
		return appRoot;
	}

	public void setAppRoot(String appRoot) {
		this.appRoot = appRoot;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public String getAppDatasource() {
		return appDatasource;
	}

	public void setAppDatasource(String appDatasource) {
		this.appDatasource = appDatasource;
	}

	public String getTomcatRoot() {
		return tomcatRoot;
	}

	public void setTomcatRoot(String tomcatRoot) {
		this.tomcatRoot = tomcatRoot;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreateUid() {
		return createUid;
	}

	public void setCreateUid(Long createUid) {
		this.createUid = createUid;
	}

}
