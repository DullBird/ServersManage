package com.server.vo.server;

import javax.validation.constraints.NotNull;

/**
 * 服务器更新创建人的参数类，用于验证参数
 * @author Dull Bird
 * @date 2015-8-22
 *
 */
public class ServerCreateUserVo {
	
	@NotNull
	private Long sId;		//服务器id
	@NotNull
	private Long userId;	//用户id
	public Long getsId() {
		return sId;
	}
	public void setsId(Long sId) {
		this.sId = sId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
