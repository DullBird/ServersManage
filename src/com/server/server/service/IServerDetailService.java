package com.server.server.service;

import java.util.List;

import com.server.entity.ServerDetail;
import com.server.entity.ServerType;
import com.server.utils.page.Pagination;
import com.server.vo.server.ServerDetailVo;

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

}
