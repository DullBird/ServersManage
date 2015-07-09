package com.server.server.dao.impl;

import org.springframework.stereotype.Repository;

import com.server.base.BaseDao;
import com.server.server.dao.IServerRelationDao;

/**
 * 
 * 服务器类型相关Dao实现类
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */

@Repository("server.dao.ServerRelationDao")
public class ServerRelationDao extends BaseDao implements IServerRelationDao {

	@Override
	public int addServerType(Long sId, Long stId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into tb_server_serverrelation ");
		sql.append(" (id, sid, stid) ");
		sql.append(" values ");
		sql.append(" seq_tb_server_serverrelation.nextval,?,? ");
		return this.saveORUpdate(sql.toString(), sId,stId);
	}

}
