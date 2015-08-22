package com.server.log.dao;

import com.server.entity.Log;

/**
 * 日志模块的Dao接口类
 * @author Dull Bird
 * @date 2015-8-17
 *
 */
public interface ILogDao {
	
	/**
	 * 生成日志
	 * @param log
	 */
	public int addLog(Log log);

}
