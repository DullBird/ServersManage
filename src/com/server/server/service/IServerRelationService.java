package com.server.server.service;

import java.util.List;

import com.server.entity.Database;
import com.server.entity.Proxy;
import com.server.entity.ServerType;
import com.server.entity.WebApp;

/**
 * 
 * 服务器类型相关业务逻辑接口
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */
public interface IServerRelationService {
	
	/**
	 * 为服务器添加类型关系
	 * @param sId		服务器id
	 * @param stId		服务器类型id
	 * @return
	 */
	public int addServerType(Long sId,Long stId);
	
	/**
	 * 解除服务器类型关系
	 * @param sId
	 * @param stId
	 * @return
	 */
	public int delServerType(Long sId,Long stId);
	
	/**
	 * 更新服务器类型
	 * @param sId		服务器id
	 * @param stidList	新选择的服务器类型
	 * @return
	 */
	public void updateServerType(Long sId,Long[] stidList);
	
	/**
	 * 根据服务器id查询出该服务器所含的类型
	 * @param sId
	 * @return
	 */
	public List<ServerType> queryServerTypeBySid(Long sId);
	
	/**
	 * 新增代理服务器
	 * @param proxy
	 * @param userId
	 * @return
	 */
	public int addProxy(Proxy proxy,Long userId);
	
	/**
	 * 根据id删除代理服务器
	 * @param id
	 * @return
	 */
	public int delProxyById(Long id);
	
	/**
	 * 根据服务器id删除代理服务器（删除全部）
	 * @param sId
	 * @return
	 */
	public int delProxyBysId(Long sId);
	
	/**
	 * 新增应用服务器
	 * @param webApp
	 * @param userId
	 * @return
	 */
	public int addWebApp(WebApp webApp,Long userId);
	
	/**
	 * 根据id删除应用服务器
	 * @param id
	 * @return
	 */
	public int delWebAppById(Long id);
	
	/**
	 * 根据服务器id删除应用服务器（删除全部）
	 * @param sId
	 * @return
	 */
	public int delWebAppBysId(Long sId);
	
	/**
	 * 新增数据库服务器
	 * @param database
	 * @param userId
	 * @return
	 */
	public int addDatabase(Database database,Long userId);
	
	/**
	 * 根据id删除数据库服务器
	 * @param id
	 * @return
	 */
	public int delDatabaseById(Long id);
	
	/**
	 * 根据服务器id删除数据库服务器（删除全部）
	 * @param sId
	 * @return
	 */
	public int delDatabaseBysId(Long sId);
	
	/**
	 * 根据服务器id查询出该服务器所有的代理服务器
	 * @param sId		服务器id
	 * @param status	主要用于区分不同角色查询1：正常 0：删除
	 * @return
	 */
	public List<Proxy> queryProxy(Long sId,Integer status);
	
	/**
	 * 根据服务器id查询出该服务器所有的应用服务器
	 * @param sId		服务器id
	 * @param status	主要用于区分不同角色查询1：正常 0：删除
	 * @return
	 */
	public List<WebApp> queryWebApp(Long sId,Integer status);
	
	/**
	 * 根据服务器id查询出该服务器所有的数据库服务器
	 * @param sId		服务器id
	 * @param status	主要用于区分不同角色查询1：正常 0：删除
	 * @return
	 */
	public List<Database> queryDatabase(Long sId,Integer status);
	
}
