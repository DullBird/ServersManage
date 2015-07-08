package com.server.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户实体
 * @author DullBird
 * @date 2015-7-6
 */
public class User {

	private Long id; 		// 用户id
	@NotEmpty
	private String userName; 	// 用户名
	@NotEmpty
	private String passWord; 	// 登陆密码
	@NotNull
	private Long rId; 			// 角色id
	@NotEmpty
	private String realName; 	// 真实姓名，管理员添加后不能修改
	private String tel; 		// 联系方式
	private Integer status; 	// 状态 1：显示 0：删除
	private Date createDate; 	// 创建时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getrId() {
		return rId;
	}

	public void setrId(Long rId) {
		this.rId = rId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
