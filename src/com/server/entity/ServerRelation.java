package com.server.entity;

/**
 * 
 * 服务器类型关系实体
 * @author DullBird
 * @date 2015-7-13
 * 
 */
public class ServerRelation {
	
	private Long id;
	private Long sId;		//服务器id
	private Long stId;		//服务器类型id
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getsId() {
		return sId;
	}
	
	public void setsId(Long sId) {
		this.sId = sId;
	}
	
	public Long getStId() {
		return stId;
	}
	
	public void setStId(Long stId) {
		this.stId = stId;
	}

}
