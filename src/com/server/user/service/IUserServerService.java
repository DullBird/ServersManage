package com.server.user.service;

import java.util.List;

import com.server.vo.user.UserServerVo;
import com.server.vo.user.UserVo;

/**
 * 
 * 用户服务器关系相关业务逻辑接口
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */
public interface IUserServerService {
	
	/**
	 * 为用户添加可管理的服务器
	 * @param userId	用户id
	 * @param sId		服务器id
	 * @return
	 */
	public int addUserServer(Long userId,Long sId);
	
	/**
	 * 根据服务器id查询出能管理该服务器的用户信息
	 * @param sId
	 * @return
	 */
	public List<UserServerVo> queryUserBySid(Long sId);
	
	/**
	 * 删除该服务器的可管理人员，除了操作人id
	 * @param sId		服务器id
	 * @param userId	操作人用户id
	 * @return
	 */
	public int delUserServer(Long sId,Long userId);

}
