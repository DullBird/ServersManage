package com.server.vo.user;

import com.server.entity.User;

/**
 * 用户vo
 * @author Dull Bird
 * @date 2015-7-6
 * 
 */
public class UserVo extends User {
	
	private String roleName;		//角色名称

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
