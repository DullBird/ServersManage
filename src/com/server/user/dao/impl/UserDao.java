package com.server.user.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.server.base.BaseDao;
import com.server.entity.User;
import com.server.user.dao.IUserDao;
import com.server.vo.user.UserVo;

/**
 * 用户模块dao实现类
 * @author Dull Bird
 * @date 2015-7-6
 * 
 */
@Repository("user.dao.UserDao")
public class UserDao extends BaseDao implements IUserDao {

	@Override
	public int addUser(User user) {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into tb_server_user ");
		sql.append(" (id, username, password, rid, realname, tel, status, createdate) ");
		sql.append(" values ");
		sql.append(" (seq_tb_server_user.nextval,?,?,?,?,?,1,sysdate) ");
		return this.saveORUpdate(sql.toString(), user.getUserName(),
				user.getPassWord(),user.getrId(),user.getRealName(),
				user.getTel());
	}

	@Override
	public UserVo getUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVo> queryUserList(String realName, String tel,
			Integer status, Long rId) {
		// TODO Auto-generated method stub
		return null;
	}

}
