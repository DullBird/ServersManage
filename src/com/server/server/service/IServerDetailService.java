package com.server.server.service;

import java.util.List;

import com.server.entity.ServerDetail;
import com.server.entity.ServerType;

/**
 * 
 * 服务器信息相关业务逻辑接口
 * @author Dull Bird
 * @date 2015-7-8
 * 
 */

public interface IServerDetailService {
	
	/**
	 * 查询服务器类型列表
	 * @return
	 */
	public List<ServerType> queryServerTypeList();
	
	/**
	 * 新增服务器
	 * @param server
	 * @param stidList		主机类型id
	 * @param userIdList	协助人员id
	 */
	public void addServer(ServerDetail server,Long[] stidList,Long[] userIdList);

}
