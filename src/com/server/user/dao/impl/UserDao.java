package com.server.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.server.base.BaseDao;
import com.server.entity.Role;
import com.server.entity.User;
import com.server.user.dao.IUserDao;
import com.server.utils.EncryptUitls;
import com.server.utils.StrUtils;
import com.server.utils.page.Pagination;
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
				EncryptUitls.MD5Digest(user.getPassWord()),user.getrId(),user.getRealName(),
				user.getTel());
	}

	@Override
	public UserVo getUser(Long userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select u.*,r.name as roleName from tb_server_user u,tb_server_role r ");
		sql.append(" where u.rid=r.id ");
		sql.append(" and u.id=? ");
		return this.queryForBean(sql.toString(), UserVo.class, userId);
	}

	@Override
	public Pagination<UserVo> queryUserList(int toPage,int pageSize,String realName, 
			String tel,Integer status, Long rId,String userName) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select u.*,r.name as roleName from tb_server_user u,tb_server_role r ");
		sql.append(" where u.rid=r.id ");
		List<Object> args = new ArrayList<Object>();
		if(!StrUtils.isEmpty(realName)){
			sql.append(" and instr(u.realname,?) > 0 ");
			args.add(realName);
		}
		if(!StrUtils.isEmpty(tel)){
			sql.append(" and instr(u.tel,?) > 0 ");
			args.add(tel);
		}
		if(null != status){
			sql.append(" and u.status=? ");
			args.add(status);
		}
		if(null != rId){
			sql.append(" and u.rid=? ");
			args.add(rId);
		}
		if(!StrUtils.isEmpty(userName)){
			sql.append(" and u.username=? ");
			args.add(userName);
		}
		return this.queryForPage(toPage, pageSize, sql.toString(), UserVo.class,args.toArray());
	}

	@Override
	public List<Role> queryRoleList() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from TB_SERVER_ROLE r where r.id <> 1 ");
		return this.queryForListBean(sql.toString(), Role.class);
	}

	@Override
	public int updateUser(String passWord, String tel, Long userId) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" update TB_SERVER_USER set ");
		if(!StrUtils.isEmpty(passWord)){
			sql.append(" password=?,");
			args.add(EncryptUitls.MD5Digest(passWord));
		}
		if(!StrUtils.isEmpty(tel)){
			sql.append(" tel=?,");
			args.add(tel);
		}
		sql.delete(sql.length()-1, sql.length());
		sql.append(" where id=? ");
		args.add(userId);
		System.out.println(sql.toString());
		return this.saveORUpdate(sql.toString(), args.toArray());
	}

	@Override
	public int updatePwd(String passWord, Long userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update TB_SERVER_USER set password=? where id=? ");
		return this.saveORUpdate(sql.toString(),EncryptUitls.MD5Digest(passWord),userId);
	}

	@Override
	public int updateTel(String tel, Long userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update TB_SERVER_USER set tel=? where id=? ");
		return this.saveORUpdate(sql.toString(),tel,userId);
	}

	@Override
	public int deleteUser(Long userId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update TB_SERVER_USER set status=0 where id=? ");
		return this.saveORUpdate(sql.toString(),userId);
	}
	
}
