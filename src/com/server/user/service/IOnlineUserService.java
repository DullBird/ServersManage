package com.server.user.service;

import com.server.utils.page.Pagination;
import com.server.vo.user.UserVo;

/**
 * 在线用户的业务逻辑接口
 * @author Dull Bird
 * @date 2015-8-19
 */
public interface IOnlineUserService {
	
	/**
	 * 增加一个在线用户（登录时调用）
	 * @param sessionId
	 * @param sessionUser
	 */
	public void addOnlineUser(String sessionId,UserVo sessionUser);
	
	/**
	 * 根据sessionId删除在线用户（注销、session销毁的时候调用）
	 * @param sessionId
	 */
	public void delOnlineUser(String sessionId);
	
	/**
	 * 列出在线用户（带分页）
	 * @param toPage
	 * @param pageSize
	 * @return
	 */
	public Pagination<UserVo> queryOnlineUser(int toPage,int pageSize);

}
