package com.server.user.dao;

/**
 * 
 * 用户服务器关系相关Dao接口
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */

public interface IUserServerDao {
	
	/**
	 * 为用户添加可管理的服务器
	 * @param userId	用户id
	 * @param sId		服务器id
	 * @return
	 */
	public int addUserServer(Long userId,Long sId);

}
