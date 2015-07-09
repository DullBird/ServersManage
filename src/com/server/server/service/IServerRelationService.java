package com.server.server.service;

/**
 * 
 * 服务器类型相关业务逻辑接口
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */
public interface IServerRelationService {
	
	/**
	 * 为服务器添加类型关系
	 * @param sId		服务器id
	 * @param stId		服务器类型id
	 * @return
	 */
	public int addServerType(Long sId,Long stId);

}
