package com.server.server.service;

import java.util.List;

import com.server.entity.ServerDetail;
import com.server.entity.ServerType;
import com.server.entity.User;
import com.server.utils.page.Pagination;
import com.server.vo.JsonResult;
import com.server.vo.server.ServerDetailVo;
import com.server.vo.user.UserVo;

/**
 * 
 * 服务器信息相关业务逻辑接口
 * @author Dull Bird
 * @date 2015-7-8
 * 
 */

public interface IServerDetailService {
	
	/**
	 * 查询服务器类型列表
	 * @return
	 */
	public List<ServerType> queryServerTypeList();
	
	/**
	 * 新增服务器
	 * @param server
	 * @param stidList		主机类型id
	 * @param userIdList	协助人员id
	 */
	public void addServer(ServerDetail server,Long[] stidList,Long[] userIdList);
	
	/**
	 * 服务器列表（某用户可管理的服务器列表，只能查出显示状态的服务器）
	 * 运维人员，观察者调用
	 * @param toPage
	 * @param pageSize
	 * @param stId
	 * @param userId
	 * @return
	 */
	public Pagination<ServerDetailVo> myServerList(int toPage,int pageSize,Long stId,Long userId);
	
	/**
	 * 服务器列表（全部服务器列表）
	 * 管理员调用
	 * @param toPage
	 * @param pageSize
	 * @param stId
	 * @param status	服务器状态
	 * @return
	 */
	public Pagination<ServerDetailVo> allServerList(int toPage,int pageSize,Long stId,Integer status);
	
	/**
	 * 根据服务器id查询出服务器详情信息
	 * @param id		服务器id
	 * @param userId	用户id
	 * @param status	状态（1：运维人员和观察查询；null或0：管理员查询）
	 * @return
	 */
	public ServerDetailVo serverDetail(Long id,Long userId,Integer status);
	
	/**
	 * 更新服务器基本信息
	 * @param server		基本信息
	 * @param stidList		新勾选的服务器类型id
	 * @param userIdList	新勾选的可管理用户id
	 * @param sessionUser	session用户
	 * @return
	 */
	public JsonResult updateServer(ServerDetail server,Long[] stidList,Long[] userIdList,UserVo sessionUser);
	
	/**
	 * 转让服务器的属主（更新创建人）
	 * @param sId
	 * @param userId
	 * @param realName
	 * @return
	 */
	public JsonResult updateServerCreateUser(Long sId,Long userId);
	
	/**
	 * 修改服务器的状态为已删除
	 * @param id			服务器id
	 * @param createUid		创建人id（出于安全考虑）
	 * @return
	 */
	public JsonResult delServer(Long id,Long createUid);

}
