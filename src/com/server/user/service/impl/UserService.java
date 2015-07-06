package com.server.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.server.entity.User;
import com.server.user.dao.IUserDao;
import com.server.user.service.IUserService;

/**
 * 用户模块业务逻辑实现类
 * @author Dull Bird
 * @date 2015-7-6
 * 
 */
@Service("user.service.UserService")
public class UserService implements IUserService {
	
	@Resource(name = "user.dao.UserDao")
	private IUserDao userDao;

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

}
