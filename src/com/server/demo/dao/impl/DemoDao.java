package com.server.demo.dao.impl;

import org.springframework.stereotype.Repository;
import com.server.base.BaseDao;
import com.server.demo.dao.IDemoDao;
import com.server.entity.Logs;
import com.server.entity.User;
import com.server.utils.page.Pagination;

@Repository("demo.dao.DemoDao")
public class DemoDao extends BaseDao implements IDemoDao{

	@Override
	public String helloWorld() {
		return "Hello World!";
	}

	@Override
	public int insertDemo(Logs log) {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into tb_server_logs ");
		sql.append(" (logid, truename, rolename, log, createdate, servername) ");
		sql.append(" values ");
		sql.append(" (seq_tb_server_logs.nextval,?,?,?,sysdate,?) ");
		return this.saveORUpdate(sql.toString(), log.getTrueName(),log.getRoleName(),
				log.getLog(),log.getServerName());
	}

	@Override
	public User queryDemo(String trueName) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from tb_server_user u ");
		sql.append(" where instr(u.truename,?)>0 ");
		return this.queryForBean(sql.toString(), User.class,trueName);
	}

	@Override
	public Pagination<Logs> pageDemo(int pageNo,int pageSize) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from tb_server_logs l order by l.logid ");
		return this.queryForPage(pageNo, pageSize, sql.toString(), Logs.class);
	}

}
