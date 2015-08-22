package com.server.log.dao.impl;

import org.springframework.stereotype.Repository;

import com.server.base.BaseDao;
import com.server.entity.Log;
import com.server.log.dao.ILogDao;

/**
 * 日志模块的Dao实现类
 * @author Dull Bird
 * @date 2015-8-17
 *
 */
@Repository("log.dao.LogDao")
public class LogDao extends BaseDao implements ILogDao{

	@Override
	public int addLog(Log log) {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into tb_server_logs ");
		sql.append(" (id, createuid, createuser, log, createdate,userid, realname, sid, sname,proxyid, webappid, databaseid) ");
		sql.append(" values ");
		sql.append(" (seq_tb_server_logs.nextval,?,?,?,sysdate,?,?,?,?,?,?,?) ");
		return this.saveORUpdate(sql.toString(), log.getCreateUid(),log.getCreateUser(),
				log.getLog(),log.getUserId(),log.getRealName(),
				log.getsId(),log.getsName(),log.getProxyId(),
				log.getWebAppId(),log.getDatabaseId());
	}
	
	

}
