package com.server.entity;

/**
 * 用户实体
 * @author DullBird
 * @date 2014-7-3
 */
public class User {

	private int userId; 		// 用户id
	private String loginName; 	// 登录名
	private String password; 	// 登陆密码
	private String trueName; 	// 真实名
	private int roleId; 		// 角色id
	private int status; 		// 状态

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
