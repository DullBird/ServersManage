package com.server.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.server.entity.ServerDetail;
import com.server.entity.ServerType;
import com.server.server.dao.IServerDetailDao;
import com.server.server.service.IServerDetailService;
import com.server.server.service.IServerRelationService;
import com.server.user.service.IUserServerService;

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
	
	@Resource(name = "server.service.ServerRelationService")
	private IServerRelationService iserverRelationService;
	
	@Resource(name = "user.service.UserServerService")
	private IUserServerService iuserServerService;

	@Override
	public List<ServerType> queryServerTypeList() {
		return iserverDetailDao.queryServerTypeList();
	}

	@Override
	public void addServer(ServerDetail server,Long[] stidList,Long[] userIdList) {
		server.setId(iserverDetailDao.getSequenceId());
		//添加服务器主体
		int res = iserverDetailDao.addServer(server);
		//添加服务器类型关系表
		for(Long stId:stidList){
			iserverRelationService.addServerType(server.getId(), stId);
		}
		//添加用户服务器关系表
		for(Long userId:userIdList){
			iuserServerService.addUserServer(userId, server.getId());
		}
	}
	
	
}
