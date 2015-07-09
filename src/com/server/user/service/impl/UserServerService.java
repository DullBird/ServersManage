package com.server.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.server.user.dao.IUserServerDao;
import com.server.user.service.IUserServerService;

/**
 * 
 * 用户服务器关系相关业务逻辑实现类
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */
@Service("user.service.UserServerService")
public class UserServerService implements IUserServerService{
	
	@Resource(name = "user.dao.UserServerDao")
	private IUserServerDao iuserServerDao;

	@Override
	public int addUserServer(Long userId, Long sId) {
		return iuserServerDao.addUserServer(userId, sId);
	}

}
