package com.server.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.server.base.BaseDao;
import com.server.user.dao.IUserServerDao;

/**
 * 
 * 用户服务器关系相关Dao实现类
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */
@Repository("user.dao.UserServerDao")
public class UserServerDao extends BaseDao implements IUserServerDao {

	@Override
	public int addUserServer(Long userId, Long sId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into tb_server_userserver ");
		sql.append(" (id, userid, sid) ");
		sql.append(" values ");
		sql.append(" seq_tb_server_userserver.nextval,?,? ");
		return this.saveORUpdate(sql.toString(), userId,sId);
	}

}
