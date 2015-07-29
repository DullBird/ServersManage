package com.server.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.server.base.StaticParam;
import com.server.entity.Database;
import com.server.entity.Proxy;
import com.server.entity.ServerType;
import com.server.entity.WebApp;
import com.server.server.dao.IServerRelationDao;
import com.server.server.service.IServerRelationService;

/**
 * 
 * 服务器类型相关业务逻辑实现类
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */
@Service("server.service.ServerRelationService")
public class ServerRelationService implements IServerRelationService {
	
	@Resource(name = "server.dao.ServerRelationDao")
	private IServerRelationDao iserverRelationDao;

	@Override
	public int addServerType(Long sId, Long stId) {
		return iserverRelationDao.addServerType(sId, stId);
	}

	@Override
	public List<ServerType> queryServerTypeBySid(Long sId) {
		return iserverRelationDao.queryServerTypeBySid(sId);
	}

	@Override
	public int addProxy(Proxy proxy,Long userId) {
		return iserverRelationDao.addProxy(proxy,userId);
	}

	@Override
	public int addWebApp(WebApp webApp,Long userId) {
		return iserverRelationDao.addWebApp(webApp,userId);
	}

	@Override
	public int addDatabase(Database database,Long userId) {
		return iserverRelationDao.addDatabase(database,userId);
	}

	@Override
	public List<Proxy> queryProxy(Long sId, Integer status) {
		return iserverRelationDao.queryProxy(sId, status);
	}

	@Override
	public List<WebApp> queryWebApp(Long sId, Integer status) {
		return iserverRelationDao.queryWebApp(sId, status);
	}

	@Override
	public List<Database> queryDatabase(Long sId, Integer status) {
		return iserverRelationDao.queryDatabase(sId, status);
	}

	@Override
	public int delProxyById(Long id) {
		return iserverRelationDao.delProxyById(id);
	}

	@Override
	public int delProxyBysId(Long sId) {
		return iserverRelationDao.delProxyBysId(sId);
	}

	@Override
	public int delWebAppById(Long id) {
		return iserverRelationDao.delWebAppById(id);
	}

	@Override
	public int delWebAppBysId(Long sId) {
		return iserverRelationDao.delWebAppBysId(sId);
	}

	@Override
	public int delDatabaseById(Long id) {
		return iserverRelationDao.delDatabaseById(id);
	}

	@Override
	public int delDatabaseBysId(Long sId) {
		return iserverRelationDao.delDatabaseBysId(sId);
	}

	@Override
	public void updateServerType(Long sId,Long[] stidList) {
		//查询出服务器原来的类型
		List<ServerType> serverTypeList = this.queryServerTypeBySid(sId);
		//找出相同的id，这些相同的id不操作
		if(null != stidList){
			for(int i=0;i<stidList.length;i++){
				for(int j=0;j<serverTypeList.size();j++){
					System.out.println("原来有的id："+serverTypeList.get(j).getId()+"===>提交的id："+stidList[i]);
					if(serverTypeList.get(j).getId().equals(stidList[i])){
						serverTypeList.remove(j);
						stidList[i] = -1l;
					}
				}
			}
		}
		
		//删除以前留下来的服务器类型
		for(ServerType serverType:serverTypeList){
			if(serverType.getTableName().equals(StaticParam.SERVER_PROXY)){
				this.delProxyBysId(sId);
			}else if(serverType.getTableName().equals(StaticParam.SERVER_WEBAPP)){
				this.delWebAppBysId(sId);
			}else if(serverType.getTableName().equals(StaticParam.SERVER_DATABASE)){
				this.delDatabaseBysId(sId);
			}
			this.delServerType(sId, serverType.getId());
		}
		//增加以前没有的服务器类型
		if(null != stidList){
			for(Long stId:stidList){
				if(stId != -1){
					this.addServerType(sId, stId);
				}
			}
		}
	}

	@Override
	public int delServerType(Long sId, Long stId) {
		return iserverRelationDao.delServerType(sId, stId);
	}

}
