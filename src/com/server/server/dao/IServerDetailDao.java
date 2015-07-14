package com.server.server.dao;

import java.util.List;

import com.server.entity.ServerDetail;
import com.server.entity.ServerType;
import com.server.utils.page.Pagination;
import com.server.vo.server.ServerDetailVo;

/**
 * 
 * 服务器信息相关Dao接口
 * @author Dull Bird
 * @date 2015-7-8
 * 
 */

public interface IServerDetailDao {
	
	/**
	 * 添加服务器
	 * @param server
	 * @return
	 */
	public int addServer(ServerDetail server);
	
	/**
	 * 查询出所有服务器类型
	 * @return
	 */
	public List<ServerType> queryServerTypeList();
	
	/**
	 * 获取tb_server_serverdetail的sequenceid
	 * @return
	 */
	public long getSequenceId();
	
	/**
	 * 根据条件查询出服务器列表
	 * @param toPage
	 * @param pageSize
	 * @param stId		服务器类型id
	 * @param userId	用户id
	 * @return
	 */
	public Pagination<ServerDetailVo> queryServerList(int toPage,int pageSize,Long stId,Long userId);
	
}
