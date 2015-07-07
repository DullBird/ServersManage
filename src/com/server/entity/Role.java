package com.server.entity;

/**
 * 角色实体
 * 
 * @author DullBird
 * @date 2015-7-7
 */
public class Role {

	private Long id;			//主键
	private String name;		//角色名
	private String remark;		//功能说明
	private Long sort;			//排序

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

}
