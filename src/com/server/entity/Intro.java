package com.server.entity;

/**
 * 服务器基本信息实体
 * @author DullBird
 * @date 2014-7-3
 */
public class Intro {
	
	private int serverId;		//id
	private String uname;		//服务器名
	private String ip;			//ip
	private String publicIp;	//公网ip
	private String model;		//服务器型号
	private String system;		//操作系统

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPublicIp() {
		return publicIp;
	}

	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

}
