package com.server.user.service;

/**
 * 
 * 用户服务器关系相关业务逻辑接口
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */
public interface IUserServerService {
	
	/**
	 * 为用户添加可管理的服务器
	 * @param userId	用户id
	 * @param sId		服务器id
	 * @return
	 */
	public int addUserServer(Long userId,Long sId);

}
