package com.server.test.server;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.server.entity.ServerType;
import com.server.server.service.IServerDetailService;
import com.server.server.service.IServerRelationService;
import com.server.test.BaseTest;
import com.server.utils.page.Pagination;
import com.server.vo.server.ServerDetailVo;

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
	
	@Test
	public void serverList(){
		/*Pagination<ServerDetailVo> all = iserverDetailService.allServerList(1, 10, null);
		List<ServerDetailVo> allList = all.getObjLists();
		System.out.println(allList.size());*/
		Pagination<ServerDetailVo> my = iserverDetailService.myServerList(1, 10, null, 7l);
		List<ServerDetailVo> myList = my.getObjLists();
		System.out.println(myList.size());
	}

}
