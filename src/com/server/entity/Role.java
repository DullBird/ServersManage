package com.server.entity;

/**
 * 角色实体
 * @author DullBird
 * @date 2014-7-3
 */
public class Role {
	
	private int roleId;		//id
	private String name;	//角色名
	private String mark;	//说明
	private int sort;		//排序
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
