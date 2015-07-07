package com.server.user.dao;

import java.util.List;

import com.server.entity.Role;
import com.server.entity.User;
import com.server.utils.page.Pagination;
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
	 * @param toPage
	 * @param pageSize
	 * @param realName
	 * @param tel
	 * @param status
	 * @param rId
	 * @return
	 */
	public Pagination<UserVo> queryUserList(int toPage,int pageSize,String realName,String tel,Integer status,Long rId);
	
	/**
	 * 查询出所有角色
	 * @return
	 */
	public List<Role> queryRoleList();

}
