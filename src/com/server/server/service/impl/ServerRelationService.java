package com.server.server.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.server.server.dao.IServerRelationDao;
import com.server.server.service.IServerRelationService;

/**
 * 
 * 服务器类型相关业务逻辑实现类
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */
@Service("server.service.ServerRelationService")
public class ServerRelationService implements IServerRelationService {
	
	@Resource(name = "server.dao.ServerRelationDao")
	private IServerRelationDao iserverRelationDao;

	@Override
	public int addServerType(Long sId, Long stId) {
		return iserverRelationDao.addServerType(sId, stId);
	}

}
