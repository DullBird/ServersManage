package com.server.entity;

import java.util.Date;

/**
 * 数据库服务器实体
 * 
 * @author DullBird
 * @date 2015-7-13
 */
public class Database {

	private Long id;					//主键
	private Long sId;					//服务器id
	private String dbSid;				//实例名
	private String dbUser;				//数据库用户
	private String dbTableSpace;		//表空间
	private String dbTempTableSpace;	//临时表空间
	private Integer status;				//状态，1：显示 0：删除
	private Date createDate;			//创建时间

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

	public String getDbSid() {
		return dbSid;
	}

	public void setDbSid(String dbSid) {
		this.dbSid = dbSid;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbTableSpace() {
		return dbTableSpace;
	}

	public void setDbTableSpace(String dbTableSpace) {
		this.dbTableSpace = dbTableSpace;
	}

	public String getDbTempTableSpace() {
		return dbTempTableSpace;
	}

	public void setDbTempTableSpace(String dbTempTableSpace) {
		this.dbTempTableSpace = dbTempTableSpace;
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

}
