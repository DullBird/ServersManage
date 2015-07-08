package com.server.server.service;

import java.util.List;

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

}
