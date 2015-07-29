package com.server.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.server.base.BaseDao;
import com.server.entity.Database;
import com.server.entity.Proxy;
import com.server.entity.ServerType;
import com.server.entity.WebApp;
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
		sql.append(" (seq_tb_server_serverrelation.nextval,?,?) ");
		return this.saveORUpdate(sql.toString(), sId,stId);
	}

	@Override
	public List<ServerType> queryServerTypeBySid(Long sId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select st.* from  ");
		sql.append(" TB_SERVER_SERVERRELATION sr,tb_server_servertype st ");
		sql.append(" where sr.stid=st.id ");
		sql.append(" and sr.sid=? ");
		return this.queryForListBean(sql.toString(), ServerType.class, sId);
	}

	@Override
	public int addProxy(Proxy proxy,Long userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into tb_server_proxy ");
		sql.append(" (id, sid, vhostname, vhostdomain, vhostroot, vhostlogs, status, createdate,createuid) ");
		sql.append(" values ");
		sql.append(" (seq_tb_server_proxy.nextval,?,?,?,?,?,1,sysdate,?) ");
		return this.saveORUpdate(sql.toString(), proxy.getsId(),
				proxy.getVhostName(),proxy.getVhostDomain(),proxy.getVhostRoot(),
				proxy.getVhostLogs(),userId);
	}

	@Override
	public int addWebApp(WebApp webApp,Long userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into tb_server_webapp ");
		sql.append(" (id, sid, appname, approot, appurl, appdatasource, tomcatroot, status, createdate,createuid) ");
		sql.append(" values ");
		sql.append(" (seq_tb_server_webapp.nextval,?,?,?,?,?,?,1,sysdate,?) ");
		return this.saveORUpdate(sql.toString(), webApp.getsId(),
				webApp.getAppName(),webApp.getAppRoot(),webApp.getAppUrl(),
				webApp.getAppDatasource(),webApp.getTomcatRoot(),userId);
	}

	@Override
	public int addDatabase(Database database,Long userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into tb_server_database ");
		sql.append(" (id, sid, dbsid, dbuser, dbtablespace, dbtemptablespace, status, createdate,createuid) ");
		sql.append(" values ");
		sql.append(" (seq_tb_server_database.nextval,?,?,?,?,?,1,sysdate,?) ");
		return this.saveORUpdate(sql.toString(), database.getsId(),
				database.getDbSid(),database.getDbUser(),database.getDbTableSpace(),
				database.getDbTempTableSpace(),userId);
	}

	@Override
	public List<Proxy> queryProxy(Long sId, Integer status) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from tb_server_proxy p where p.sid=? ");
		if(null != status && status == 1){
			sql.append(" and p.status=1 ");
		}
		return this.queryForListBean(sql.toString(), Proxy.class, sId);
	}

	@Override
	public List<WebApp> queryWebApp(Long sId, Integer status) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from tb_server_webapp w where w.sid=? ");
		if(null != status && status == 1){
			sql.append(" and w.status=1 ");
		}
		return this.queryForListBean(sql.toString(), WebApp.class, sId);
	}

	@Override
	public List<Database> queryDatabase(Long sId, Integer status) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from tb_server_database d where d.sid=? ");
		if(null != status && status == 1){
			sql.append(" and d.status=1 ");
		}
		return this.queryForListBean(sql.toString(), Database.class, sId);
	}

	@Override
	public int delProxyById(Long id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update TB_SERVER_PROXY p set p.status=0 where p.id=? ");
		return this.saveORUpdate(sql.toString(), id);
	}

	@Override
	public int delProxyBysId(Long sId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update TB_SERVER_PROXY p set p.status=0 where p.sid=? and p.status=1 ");
		return this.saveORUpdate(sql.toString(), sId);
	}

	@Override
	public int delWebAppById(Long id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update tb_server_webapp w set w.status=0 where w.id=? ");
		return this.saveORUpdate(sql.toString(), id);
	}

	@Override
	public int delWebAppBysId(Long sId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update tb_server_webapp w set w.status=0 where w.sid=? and w.status=1 ");
		return this.saveORUpdate(sql.toString(), sId);
	}

	@Override
	public int delDatabaseById(Long id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update tb_server_database db set db.status=0 where db.id=? ");
		return this.saveORUpdate(sql.toString(), id);
	}

	@Override
	public int delDatabaseBysId(Long sId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update tb_server_database db set db.status=0 where db.sid=? and db.status=1 ");
		return this.saveORUpdate(sql.toString(), sId);
	}

	@Override
	public int delServerType(Long sId, Long stId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" delete from TB_SERVER_SERVERRELATION sr where sr.sid=? and sr.stid=? ");
		return this.saveORUpdate(sql.toString(), sId,stId);
	}

}
