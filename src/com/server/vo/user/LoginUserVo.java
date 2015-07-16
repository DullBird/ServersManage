package com.server.vo.user;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用于用户登录时传输参数的vo
 * @author DullBird
 * @date 2015-7-15
 */
public class LoginUserVo {

	@NotEmpty
	private String userName;	//用户名
	@NotEmpty
	private String passWord;	//密码
	@NotEmpty
	private String verifyCode;	//验证码
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

}
