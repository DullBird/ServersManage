package com.server.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.server.base.BaseDao;
import com.server.user.dao.IUserServerDao;
import com.server.vo.user.UserServerVo;
import com.server.vo.user.UserVo;

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
		sql.append(" (seq_tb_server_userserver.nextval,?,?) ");
		return this.saveORUpdate(sql.toString(), userId,sId);
	}

	@Override
	public List<UserServerVo> queryUserBySid(Long sId,Long rId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select u.id,u.userName,r.name as roleName,u.realName from ");
		sql.append(" TB_SERVER_USERSERVER us,tb_server_user u,tb_server_role r  ");
		sql.append(" where us.userid=u.id ");
		sql.append(" and u.rid=r.id  ");
		sql.append(" and us.sid=? ");
		List<Object> params = new ArrayList<Object>();
		params.add(sId);
		if(null != rId){
			sql.append(" and u.rid=? ");
			params.add(rId);
		}
		return this.queryForListBean(sql.toString(), UserServerVo.class, params.toArray());
	}

	@Override
	public int delUserServer(Long sId, Long userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" delete from TB_SERVER_USERSERVER us   ");
		sql.append(" where us.sid=? ");
		sql.append(" and us.userid<>? ");
		return this.saveORUpdate(sql.toString(), sId,userId);
	}

}
