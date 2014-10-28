package com.server.entity;

/**
 * 服务器详情实体
 * @author DullBird
 * @date 2014-7-3
 */
public class Detail {
	
	private int serverId;			//服务器id
	private String cabinet;			//放置的机柜
	private String serviceTag;		//服务编号
	private String deviceNum;		//邮政设备号
	private String password;		//密码
	private String vncPassword;		//vnc密码
	private Object param;			//服务器配置
	private Object mark;			//备注

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public String getCabinet() {
		return cabinet;
	}

	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}

	public String getServiceTag() {
		return serviceTag;
	}

	public void setServiceTag(String serviceTag) {
		this.serviceTag = serviceTag;
	}

	public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVncPassword() {
		return vncPassword;
	}

	public void setVncPassword(String vncPassword) {
		this.vncPassword = vncPassword;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	public Object getMark() {
		return mark;
	}

	public void setMark(Object mark) {
		this.mark = mark;
	}

}
