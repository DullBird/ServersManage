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
	 * @param status	状态 0：删除 1：显示
	 * @param id		服务器id
	 * @return
	 */
	public Pagination<ServerDetailVo> queryServerList(int toPage,int pageSize,Long stId,Long userId,Integer status,Long id);
	
	/**
	 * 更新服务器基本信息
	 * @param server
	 * @return
	 */
	public int updateServer(ServerDetail server);
	
	/**
	 * 更改服务器的创建人id和创建人
	 * @param id
	 * @param userId
	 * @param realName
	 * @return
	 */
	public int updateServerCreateUser(Long id,Long userId,String realName);
	
	/**
	 * 修改服务器的状态为已删除
	 * @param id			服务器id
	 * @param createUid 	创建人id（出于安全考虑）
	 * @return
	 */
	public int delServer(Long id,Long createUid);
	
}
