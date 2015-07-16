package com.server.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.server.entity.Role;
import com.server.entity.User;
import com.server.user.dao.IUserDao;
import com.server.user.service.IUserService;
import com.server.utils.EncryptUitls;
import com.server.utils.StrUtils;
import com.server.utils.page.Pagination;
import com.server.vo.JsonResult;
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
		return userDao.queryUserList(toPage, pageSize, realName, tel, status, rId,null);
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

	@Override
	public UserVo getUser(Long userId) {
		return userDao.getUser(userId);
	}

	@Override
	public int updateUser(String passWord, String tel, Long userId) {
		return userDao.updateUser(passWord, tel, userId);
	}

	@Override
	public JsonResult updatePwd(String oldPwd,String newPwd,Long userId) {
		UserVo user = userDao.getUser(userId);
		if(user.getPassWord().equals(EncryptUitls.MD5Digest(oldPwd))){
			this.updatePwd(newPwd, userId);
			return new JsonResult(true);
		}else{
			return new JsonResult(false,"旧密码错误");
		}
	}

	@Override
	public int updateTel(String tel, Long userId) {
		return userDao.updateTel(tel, userId);
	}

	@Override
	public int updatePwd(String passWord, Long userId) {
		return userDao.updatePwd(passWord, userId);
	}

	@Override
	public int deleteUser(Long userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public List<UserVo> queryAddServerUser() {
		List<UserVo> userList = new ArrayList<UserVo>();
		//添加运维人员
		userList.addAll(this.queryUserList(1, 100, null, null, 1, 2l).getObjLists());
		//添加观察者
		userList.addAll(this.queryUserList(1, 100, null, null, 1, 3l).getObjLists());
		return userList;
	}

	@Override
	public UserVo queryUserByUserName(String userName) {
		//查询出状态为1（正常）的用户
		List<UserVo> userList = userDao.queryUserList(1, 10, null, null, 1, null, userName).getObjLists();
		if(userList.size() > 0){
			return userList.get(0);
		}
		return null;
	}
	
}
