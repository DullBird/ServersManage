package com.server.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.server.base.BaseDao;
import com.server.entity.ServerDetail;
import com.server.entity.ServerType;
import com.server.server.dao.IServerDetailDao;

/**
 * 
 * 服务器信息相关Dao实现类
 * @author Dull Bird
 * @date 2015-7-8
 * 
 */

@Repository("server.dao.ServerDao")
public class ServerDetailDao extends BaseDao implements IServerDetailDao {

	@Override
	public int addServer(ServerDetail server) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ServerType> queryServerTypeList() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from TB_SERVER_SERVERTYPE ");
		return this.queryForListBean(sql.toString(), ServerType.class);
	}
	

}
