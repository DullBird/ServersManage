package com.server.log.service;

import org.aspectj.lang.JoinPoint;

import com.server.entity.Log;

/**
 * 日志模块的业务逻辑接口类
 * @author Dull Bird
 * @date 2015-8-17
 *
 */
public interface ILogService {
	
	/**
	 * 添加日志
	 * @param log
	 * @return
	 */
	public int addLog(Log log);

}
