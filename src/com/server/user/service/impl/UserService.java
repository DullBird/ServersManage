package com.server.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.server.entity.Role;
import com.server.entity.User;
import com.server.user.dao.IUserDao;
import com.server.user.service.IUserService;
import com.server.utils.page.Pagination;
import com.server.vo.user.UserVo;

/**
 * 用户模块业务逻辑实现类
 * @author Dull Bird
 * @date 2015-7-6
 * 
 */
@Service("user.service.UserService")
public class UserService implements IUserService {
	
	@Resource(name = "user.dao.UserDao")
	private IUserDao userDao;

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public List<Role> queryRoleList() {
		return userDao.queryRoleList();
	}

	@Override
	public Pagination<UserVo> queryUserList(int toPage, int pageSize,
			String realName, String tel, Integer status, Long rId) {
		return userDao.queryUserList(toPage, pageSize, realName, tel, status, rId);
	}

	@Override
	public boolean checkUserExist(String realName) {
		List<UserVo> userList = this.queryUserList(1, 100, realName, null, null, null).getObjLists();
		if(userList.size() > 0){
			for(UserVo user:userList){
				if(user.getRealName().equals(realName)){
					return true;
				}
			}
		}
		return false;
	}
	
}
