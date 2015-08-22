package com.server.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.server.base.StaticParam;
import com.server.entity.ServerDetail;
import com.server.entity.ServerType;
import com.server.entity.User;
import com.server.server.dao.IServerDetailDao;
import com.server.server.service.IServerDetailService;
import com.server.server.service.IServerRelationService;
import com.server.user.service.IUserServerService;
import com.server.user.service.IUserService;
import com.server.utils.page.Pagination;
import com.server.vo.JsonResult;
import com.server.vo.server.ServerDetailVo;
import com.server.vo.user.UserServerVo;
import com.server.vo.user.UserVo;

/**
 * 
 * 服务器信息相关业务逻辑接口
 * @author Dull Bird
 * @date 2015-7-8
 * 
 */

@Service("server.service.ServerDetailService")
public class ServerDetailService implements IServerDetailService {

	@Resource(name = "server.dao.ServerDao")
	private IServerDetailDao iserverDetailDao;
	
	@Resource(name = "server.service.ServerRelationService")
	private IServerRelationService iserverRelationService;
	
	@Resource(name = "user.service.UserServerService")
	private IUserServerService iuserServerService;
	
	@Resource(name = "user.service.UserService")
	private IUserService iuserService;

	@Override
	public List<ServerType> queryServerTypeList() {
		return iserverDetailDao.queryServerTypeList();
	}

	@Override
	public void addServer(ServerDetail server,Long[] stidList,Long[] userIdList) {
		server.setId(iserverDetailDao.getSequenceId());
		//添加服务器主体
		int res = iserverDetailDao.addServer(server);
		//添加服务器类型关系表
		if(null != stidList){
			for(Long stId:stidList){
				iserverRelationService.addServerType(server.getId(), stId);
			}
		}
		for(Long userId:userIdList){
			//添加用户服务器关系表
			iuserServerService.addUserServer(userId, server.getId());
		}
	}

	@Override
	public Pagination<ServerDetailVo> myServerList(int toPage, int pageSize,
			Long stId, Long userId) {
		return iserverDetailDao.queryServerList(toPage, pageSize, stId, userId,1,null);
	}

	@Override
	public Pagination<ServerDetailVo> allServerList(int toPage, int pageSize,
			Long stId,Integer status) {
		return iserverDetailDao.queryServerList(toPage, pageSize, stId, null,status,null);
	}

	@Override
	public ServerDetailVo serverDetail(Long id,Long userId,Integer status) {
		//查询出服务器的基本信息
		List<ServerDetailVo> serverList = iserverDetailDao.queryServerList(1, 2, null, userId, status, id).getObjLists();
		if(null != serverList && serverList.size() != 1){
			return null;
		}
		ServerDetailVo server = serverList.get(0);
		//查询出该服务器其他管理人员信息
		List<UserServerVo> userServerList = iuserServerService.queryUserBySid(id);
		server.setUserServerList(userServerList);
		//查询出该服务器的所有服务器类型（代理，应用，数据库）
		List<ServerType> serverTypeList = iserverRelationService.queryServerTypeBySid(id);
		server.setServerTypeList(serverTypeList);
		for(ServerType serverType:serverTypeList){
			if(serverType.getTableName().equals(StaticParam.SERVER_PROXY)){
				//查询代理服务器
				server.setProxyList(iserverRelationService.queryProxy(id, 1));
			}else if(serverType.getTableName().equals(StaticParam.SERVER_WEBAPP)){
				//查询应用服务器
				server.setWebAppList(iserverRelationService.queryWebApp(id, 1));
			}else if(serverType.getTableName().equals(StaticParam.SERVER_DATABASE)){
				//查询数据库服务器
				server.setDbList(iserverRelationService.queryDatabase(id, 1));
			}
		}
		return server;
	}

	@Override
	public JsonResult updateServer(ServerDetail server,Long[] stidList,
			Long[] userIdList,UserVo sessionUser) {
		//查询出服务器的基本信息
		List<ServerDetailVo> serverList = iserverDetailDao.queryServerList(1, 2, null, null, 1, server.getId()).getObjLists();
		if(null != serverList && serverList.size() != 1){
			return new JsonResult(false, "找不到对应的服务器信息");
		}
		ServerDetailVo serverTemp = serverList.get(0);
		//如果操作用户不等于该服务器的创建用户，不予修改用户服务器关系表
		if(serverTemp.getCreateUid() == sessionUser.getId()){
			//删掉除了自己的所有可管理人员，再更新
			iuserServerService.delUserServer(server.getId(), sessionUser.getId());
			if(null != userIdList){
				for(Long userId:userIdList){
					iuserServerService.addUserServer(userId, server.getId());
				}
			}
			
		}
		//更新服务器类型
		iserverRelationService.updateServerType(server.getId(), stidList);
		//更新服务器基本信息
		iserverDetailDao.updateServer(server);
		return new JsonResult(true);
	}

	@Override
	public JsonResult delServer(Long id,Long createUid) {
		iserverDetailDao.delServer(id,createUid);
		return new JsonResult(true);
	}

	@Override
	public JsonResult updateServerCreateUser(Long sId, Long userId) {
		List<UserServerVo> userServerList = iuserServerService.queryOperationBySid(sId);
		UserServerVo userServerVo = null;
		//处于安全考虑，遍历查询该userId是否页面选择的值
		for(UserServerVo temp:userServerList){
			if(temp.getId().equals(userId)){
				userServerVo = temp;
				break;
			}
		}
		//如果为空，不存在
		if(null == userServerVo){
			return new JsonResult(false,"无效的运维人员");
		}
		iserverDetailDao.updateServerCreateUser(sId, userServerVo.getId(), userServerVo.getRealName());
		return new JsonResult(true);
	}
	
}
