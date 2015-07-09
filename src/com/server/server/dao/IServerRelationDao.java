package com.server.server.dao;

/**
 * 
 * 服务器类型相关Dao接口
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */

public interface IServerRelationDao {
	
	/**
	 * 为服务器添加类型关系
	 * @param sId		服务器id
	 * @param stId		服务器类型id
	 * @return
	 */
	public int addServerType(Long sId,Long stId);

}