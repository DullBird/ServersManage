package com.server.entity;

/**
 * 服务器类型实体
 * @author DullBird
 * @date 2015-7-8
 */
public class ServerType {

	private Long id;
	private String name; 		// 名称
	private String tableName; 	// 对应表名

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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
