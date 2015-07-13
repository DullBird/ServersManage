package com.server.entity;

/**
 * 
 * 用户服务器实体
 * @author DullBird
 * @date 2015-7-13
 * 
 */
public class UserServer {

	private Long id;
	private Long userId;	//用户id
	private Long sId;		//服务器id

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
