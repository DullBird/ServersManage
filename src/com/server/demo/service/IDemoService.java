package com.server.demo.service;

import com.server.entity.Logs;
import com.server.entity.User;
import com.server.utils.page.Pagination;

public interface IDemoService {
	
	public String helloWorld();
	
	//插入示例
	public int insertDemo(Logs log);
	
	//查询示例
	public User queryDemo(String trueName);
	
	//分页示例
	public Pagination<Logs> pageDemo(int pageNo,int pageSize);

}
