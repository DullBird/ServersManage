package com.server.test.server;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.server.entity.Database;
import com.server.entity.Proxy;
import com.server.entity.ServerDetail;
import com.server.entity.ServerType;
import com.server.entity.WebApp;
import com.server.server.dao.IServerDetailDao;
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
	
	@Resource(name = "server.dao.ServerDao")
	private IServerDetailDao iserverDetailDao;
	
	@Test
	public void serverTypeList(){
		/*List<ServerType> serverTypeList = iserverDetailService.queryServerTypeList();
		System.out.println(serverTypeList.size());*/
		List<Proxy> proxyList = iserverRelationService.queryProxy(1l, null);
		System.out.println(proxyList.size());
		List<WebApp> webappList = iserverRelationService.queryWebApp(1l, 1);
		System.out.println(webappList.size());
		List<Database> databaseList = iserverRelationService.queryDatabase(1l, null);
		System.out.println(databaseList.size());
	}
	
	@Test
	public void addServer(){
		Proxy proxy = new Proxy();
		proxy.setsId(22l);
		proxy.setVhostName("imgs.ichsh.cn");
		proxy.setVhostDomain("imgs.ichsh.cn");
		proxy.setVhostLogs("/var/log/imgs");
		proxy.setVhostRoot("/home/share/imgs");
		System.out.println(iserverRelationService.addProxy(proxy,1l));
		/*WebApp webApp = new WebApp();
		webApp.setsId(1l);
		webApp.setAppName("常惠生活");
		webApp.setAppRoot("/svc/www/ichsh");
		webApp.setAppDatasource("ichsh/dg11185_ichsh");
		webApp.setAppUrl("www.ichsh.com");
		webApp.setTomcatRoot("/opt/tomcat/tomcat_chsh");
		System.out.println(iserverRelationService.addWebApp(webApp));*/
		/*Database database = new Database();
		database.setsId(1l);
		database.setDbSid("mailer");
		database.setDbTableSpace("tbs_chsh");
		database.setDbTempTableSpace("temp");
		database.setDbUser("chsh");
		System.out.println(iserverRelationService.addDatabase(database));*/
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
	
	@Test
	public void updateServer(){
		ServerDetail server = new ServerDetail();
		server.setId(1l);
		server.setIsVirtual(0);
		server.setName("asd");
		server.setCpu("asd");
		server.setMemory("asd");
		server.setHardDisk("asd");
		server.setOs("asd");
		server.setIp("asd");
		server.setPublicIp("asd");
		server.setRemark("asd");
		server.setModel("asd");
		server.setServices("asd");
		server.setPostDeviceCode("asd");
		iserverDetailDao.updateServer(server);
	}
	
}
