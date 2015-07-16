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
	 * @param userName
	 * @return
	 */
	public Pagination<UserVo> queryUserList(int toPage,int pageSize,String realName,String tel,Integer status,Long rId,String userName);
	
	/**
	 * 查询出所有角色
	 * @return
	 */
	public List<Role> queryRoleList();
	
	/**
	 * 修改密码
	 * @param passWord
	 * @param userId
	 * @return
	 */
	public int updatePwd(String passWord,Long userId);
	
	/**
	 * 修改联系电话
	 * @param tel
	 * @param userId
	 * @return
	 */
	public int updateTel(String tel,Long userId);
	
	/**
	 * 修改用户信息，可修改的只有密码和联系电话（过期，保留）
	 * @param passWord
	 * @param tel
	 * @param userId
	 * @return
	 */
	@Deprecated
	public int updateUser(String passWord,String tel,Long userId);
	
	/**
	 * 删除用户（状态值置0）
	 * @param userId
	 * @return
	 */
	public int deleteUser(Long userId);

}
