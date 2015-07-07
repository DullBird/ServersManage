package com.server.user.service;

import java.util.List;

import com.server.entity.Role;
import com.server.entity.User;
import com.server.utils.page.Pagination;
import com.server.vo.user.UserVo;

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
	
	/**
	 * 查询出所有角色
	 * @return
	 */
	public List<Role> queryRoleList();
	
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
	 * 验证用户是否已经存在
	 * @param realName
	 * @return
	 */
	public boolean checkUserExist(String realName);

}
