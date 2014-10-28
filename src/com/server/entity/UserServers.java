package com.server.entity;

/**
 * 用户管理服务器的实体
 * @author DullBird
 * @date 2014-7-3
 */
public class UserServers {

	private int id;
	private int userId; 	// 用户id
	private int serverId; 	// 服务器id

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

}
