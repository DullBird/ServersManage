package com.server.vo.user;

import javax.servlet.http.HttpSession;

import com.server.base.StaticParam;
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
	
	//获取session当中的user对象
	public static UserVo getSessionUser(HttpSession session){
		return (UserVo) session.getAttribute(StaticParam.SESSION_USER);
	}

}
