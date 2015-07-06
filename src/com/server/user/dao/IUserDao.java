package com.server.user.dao;

import java.util.List;

import com.server.entity.User;
import com.server.vo.user.UserVo;

/**
 * 用户模块dao接口
 * @author Dull Bird
 * @date 2015-7-6
 * 
 */

public interface IUserDao {
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * 根据用户id查询出用户
	 * @param userId
	 * @return
	 */
	public UserVo getUser(Long userId);
	
	/**
	 * 根据条件查询出用户
	 * @param realName
	 * @param tel
	 * @param status
	 * @param rId
	 * @return
	 */
	public List<UserVo> queryUserList(String realName,String tel,Integer status,Long rId);

}
