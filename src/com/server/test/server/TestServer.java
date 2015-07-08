package com.server.test.server;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.server.entity.ServerType;
import com.server.server.service.IServerDetailService;
import com.server.test.BaseTest;

public class TestServer extends BaseTest {
	
	@Resource(name = "server.service.ServerDetailService")
	private IServerDetailService iserverDetailService;
	
	@Test
	public void serverTypeList(){
		List<ServerType> serverTypeList = iserverDetailService.queryServerTypeList();
		System.out.println(serverTypeList.size());
	}

}
