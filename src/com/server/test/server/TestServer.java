package com.server.test.server;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.server.entity.ServerType;
import com.server.server.service.IServerDetailService;
import com.server.server.service.IServerRelationService;
import com.server.test.BaseTest;

public class TestServer extends BaseTest {
	
	@Resource(name = "server.service.ServerDetailService")
	private IServerDetailService iserverDetailService;
	
	@Resource(name = "server.service.ServerRelationService")
	private IServerRelationService iserverRelationService;
	
	@Test
	public void serverTypeList(){
		List<ServerType> serverTypeList = iserverDetailService.queryServerTypeList();
		System.out.println(serverTypeList.size());
	}
	
	@Test
	public void addServer(){
		System.out.println(iserverRelationService.addServerType(1l, 1l));
		
	}

}
