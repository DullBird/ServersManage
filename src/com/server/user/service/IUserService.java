package com.server.user.service;

import java.util.List;

import com.server.entity.Role;
import com.server.entity.User;
import com.server.utils.page.Pagination;
import com.server.vo.JsonResult;
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
	
	/**
	 * 根据用户id查询出用户
	 * @param userId
	 * @return
	 */
	public UserVo getUser(Long userId);
	
	/**
	 * 修改用户信息，可修改的只有密码和联系电话
	 * @param passWord
	 * @param tel
	 * @param userId
	 * @return
	 */
	public int updateUser(String passWord,String tel,Long userId);
	
	/**
	 * 修改密码（含验证旧密码）
	 * @param oldPwd
	 * @param newPwd
	 * @param userId
	 * @return
	 */
	public JsonResult updatePwd(String oldPwd,String newPwd,Long userId);
	
	/**
	 * 修改联系电话
	 * @param tel
	 * @param userId
	 * @return
	 */
	public int updateTel(String tel,Long userId);
	
	/**
	 * 修改密码（直接调用dao方法）
	 * @param passWord
	 * @param userId
	 * @return
	 */
	public int updatePwd(String passWord,Long userId);
	
	/**
	 * 删除用户（状态值置0）
	 * @param userId
	 * @return
	 */
	public int deleteUser(Long userId);
	
	/**
	 * 查询出可为主机添加管理或观察的用户
	 * 条件：
	 * 	角色：运维人员或观察者
	 *  状态：正常
	 * @return
	 */
	public List<UserVo> queryAddServerUser();
	
}
