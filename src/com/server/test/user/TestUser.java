package com.server.test.user;

import javax.annotation.Resource;

import org.junit.Test;

import com.server.entity.User;
import com.server.test.BaseTest;
import com.server.user.service.IUserService;
import com.server.utils.page.Pagination;
import com.server.vo.user.UserVo;

public class TestUser extends BaseTest {
	
	@Resource(name = "user.service.UserService")
	private IUserService iuserService;
	
	
	@Test
	public void addUser(){
		User user = new User();
		user.setUserName("admin");
		user.setPassWord("123456");
		user.setRealName("超级管理员");
		user.setTel("88888888888");
		user.setrId(1l);
		System.out.println(iuserService.addUser(user));
	}
	
	@Test
	public void queryUser(){
		Pagination<UserVo> pagination = iuserService.queryUserList(1, 10, "赖永", null, null, null);
		System.out.println(pagination.getObjLists().size());
	}
	
	@Test
	public void checkUserEsixt(){
		System.out.println(iuserService.checkUserExist("赖永钊"));
	}
	
	@Test
	public void getUser(){
		UserVo user = iuserService.getUser(2l);
		System.out.println(user.getRoleName());
	}
	
	@Test
	public void updateUser(){
		System.out.println(iuserService.updatePwd("654","123456", 2l));
		System.out.println(iuserService.updateTel("sssssss", 2l));
		//System.out.println(iuserService.updateUser("", "123", 2l));
	}
	
	@Test
	public void resetPwd(){
		iuserService.updatePwd("123456", 62l);
		//iuserService.updatePwd("dg11185", "123", 62l);
	}

}
