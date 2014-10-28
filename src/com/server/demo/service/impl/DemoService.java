package com.server.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.server.demo.dao.IDemoDao;
import com.server.demo.service.IDemoService;
import com.server.entity.Logs;
import com.server.entity.User;
import com.server.utils.page.Pagination;

@Service("demo.server.DemoService")
public class DemoService implements IDemoService{

	private IDemoDao idemoDao;
	
	@Resource(name = "demo.dao.DemoDao")
	public void setIdemoDao(IDemoDao idemoDao) {
		this.idemoDao = idemoDao;
	}

	@Override
	public String helloWorld() {
		return idemoDao.helloWorld();
	}

	@Override
	public int insertDemo(Logs log) {
		return idemoDao.insertDemo(log);
	}

	@Override
	public User queryDemo(String trueName) {
		return idemoDao.queryDemo(trueName);
	}

	@Override
	public Pagination<Logs> pageDemo(int pageNo, int pageSize) {
		return idemoDao.pageDemo(pageNo, pageSize);
	}

}
