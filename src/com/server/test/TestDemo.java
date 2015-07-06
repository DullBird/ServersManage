package com.server.test;

import javax.annotation.Resource;
import org.junit.Test;
import com.server.demo.service.IDemoService;
import com.server.entity.Logs;
import com.server.entity.User;
import com.server.utils.page.Pagination;

/**
 * 测试类
 * @author DullBird
 *
 */
public class TestDemo extends BaseTest{
	
	private IDemoService idemoService;
	
	@Resource(name = "demo.server.DemoService")
	public void setIdemoService(IDemoService idemoService) {
		this.idemoService = idemoService;
	}
 
	@Test
	public void test(){
		Logs log = new Logs();
		log.setLog("测试");
		log.setRoleName("超级管理员");
		log.setServerName("dgpostdzsc");
		log.setTrueName("赖永钊");
		for(int i=20;i>=1;i--){
			System.out.println(idemoService.insertDemo(log));
		}
		User user = idemoService.queryDemo("admin");
		/*if(null != user){
			System.out.println("trueName:"+user.getTrueName());
		}*/
		Pagination<Logs> pagination = idemoService.pageDemo(1, 2);
		System.out.println(pagination.getTotalRows());
	}

}
