package com.server.log.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.server.base.StaticParam;
import com.server.entity.Log;
import com.server.entity.User;
import com.server.log.dao.ILogDao;
import com.server.log.service.ILogService;
import com.server.user.service.IUserService;
import com.server.utils.ServiceFacade;
import com.server.vo.user.UserVo;

/**
 * 日志模块的业务逻辑实现类
 * @author Dull Bird
 * @date 2015-8-17
 *
 */

@Service("log.service.LogService")
public class LogService implements ILogService {
	
	@Resource(name = "log.dao.LogDao")
	private ILogDao logDao;

	@Override
	public int addLog(Log log) {
		return logDao.addLog(log);
	}

}
