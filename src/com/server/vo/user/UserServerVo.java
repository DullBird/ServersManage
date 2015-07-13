package com.server.vo.user;

import com.server.entity.UserServer;

/**
 * 
 * 用户服务器vo
 * @author DullBird
 * @date 2015-7-13
 * 
 */
public class UserServerVo extends UserServer {
	
	private String userName;	//用户名

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
