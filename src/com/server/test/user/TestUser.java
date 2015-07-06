package com.server.test.user;

import javax.annotation.Resource;

import org.junit.Test;

import com.server.entity.User;
import com.server.test.BaseTest;
import com.server.user.service.IUserService;

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

}
