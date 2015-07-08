package com.server.server.dao;

import java.util.List;

import com.server.entity.ServerDetail;
import com.server.entity.ServerType;

/**
 * 
 * 服务器信息相关Dao接口
 * @author Dull Bird
 * @date 2015-7-8
 * 
 */

public interface IServerDetailDao {
	
	/**
	 * 添加服务器
	 * @param server
	 * @return
	 */
	public int addServer(ServerDetail server);
	
	/**
	 * 查询出所有服务器类型
	 * @return
	 */
	public List<ServerType> queryServerTypeList();

}
