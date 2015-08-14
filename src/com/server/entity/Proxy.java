package com.server.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 代理服务器实体
 * 
 * @author DullBird
 * @date 2015-7-13
 */
public class Proxy {

	private Long id;
	@NotNull
	private Long sId;				//服务器id
	@NotEmpty
	private String vhostName;		//虚拟主机名
	@NotEmpty
	private String vhostDomain;		//访问域名，多个已,分隔
	@NotEmpty
	private String vhostRoot;		//根路径，若为代理则保持代理ip和端口
	@NotEmpty
	private String vhostLogs;		//日志路径，包括错误和正确日志路径
	private Integer status;			//状态，1：显示 0：删除
	private Date createDate;		//创建时间
	private Long createUid;			//创建人id;

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

	public String getVhostName() {
		return vhostName;
	}

	public void setVhostName(String vhostName) {
		this.vhostName = vhostName;
	}

	public String getVhostDomain() {
		return vhostDomain;
	}

	public void setVhostDomain(String vhostDomain) {
		this.vhostDomain = vhostDomain;
	}

	public String getVhostRoot() {
		return vhostRoot;
	}

	public void setVhostRoot(String vhostRoot) {
		this.vhostRoot = vhostRoot;
	}

	public String getVhostLogs() {
		return vhostLogs;
	}

	public void setVhostLogs(String vhostLogs) {
		this.vhostLogs = vhostLogs;
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
