package com.server.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.server.entity.ServerType;
import com.server.server.dao.IServerDetailDao;
import com.server.server.service.IServerDetailService;

/**
 * 
 * 服务器信息相关业务逻辑接口
 * @author Dull Bird
 * @date 2015-7-8
 * 
 */

@Service("server.service.ServerDetailService")
public class ServerDetailService implements IServerDetailService {

	@Resource(name = "server.dao.ServerDao")
	private IServerDetailDao iserverDetailDao;

	@Override
	public List<ServerType> queryServerTypeList() {
		return iserverDetailDao.queryServerTypeList();
	}
	
	
}
