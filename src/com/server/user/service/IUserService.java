package com.server.user.service;

import com.server.entity.User;

/**
 * 用户模块业务逻辑接口
 * @author Dull Bird
 * @date 2015-7-6
 * 
 */
public interface IUserService {
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);

}
