package com.server.aop;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.server.entity.Database;
import com.server.entity.Log;
import com.server.entity.Proxy;
import com.server.entity.ServerDetail;
import com.server.entity.WebApp;
import com.server.log.service.ILogService;
import com.server.server.service.IServerDetailService;
import com.server.server.service.IServerRelationService;
import com.server.utils.ServiceFacade;
import com.server.vo.JsonResult;
import com.server.vo.user.UserVo;

/**
 * 记录服务器模块的日志aop
 * @author Dull Bird
 * @date 2015-8-21
 */
@Aspect
@Component
public class ServerLogAop {
	
	@Resource(name = "log.service.LogService")
	private ILogService logService;
	
	@Resource(name = "server.service.ServerDetailService")
	private IServerDetailService serverDetailService;
	
	@Resource(name = "server.service.ServerRelationService")
	private IServerRelationService serverRelationService;
	
	/**
	 * 记录添加服务器日志
	 * @param point
	 */
	@After("execution(* com.server.server.service.IServerDetailService.addServer(..))")
	public void addServer(JoinPoint point){
		Object[] args = point.getArgs();
		ServerDetail serverDetail = (ServerDetail) args[0];
		Log log = this.generateLog();
		log.setsId(serverDetail.getId());
		log.setsName(serverDetail.getName());
		log.setLog("添加"+serverDetail.getName()+"服务器");
		logService.addLog(log);
	}
	
	/**
	 * 记录修改服务器信息日志
	 * @param point
	 */
	@AfterReturning(pointcut = "execution(* com.server.server.service.IServerDetailService.updateServer(..))",
			returning = "returnValue")
	public void updateServer(JoinPoint point,Object returnValue){
		JsonResult res = (JsonResult) returnValue;
		if(res.isSuccess()){
			Object[] args = point.getArgs();
			ServerDetail serverDetail = (ServerDetail) args[0];
			Log log = this.generateLog();
			log.setsId(serverDetail.getId());
			log.setsName(serverDetail.getName());
			log.setLog("修改"+serverDetail.getName()+"服务器信息");
			logService.addLog(log);
		}
		
	}
	
	/**
	 * 记录删除服务器日志
	 * @param point
	 */
	@AfterReturning(pointcut = "execution(* com.server.server.service.IServerDetailService.delServer(..))",
			returning = "returnValue")
	public void delServer(JoinPoint point,Object returnValue){
		JsonResult res = (JsonResult) returnValue;
		if(res.isSuccess()){
			Object[] args = point.getArgs();
			Long sId = (Long) args[0];
			Long userId = (Long) args[1];
			//查询出此次删除的服务器信息，因为执行此日志前已经更改了状态值为0，所以状态值传null
			ServerDetail serverDetail = serverDetailService.serverDetail(sId, userId, null);
			Log log = this.generateLog();
			log.setsId(serverDetail.getId());
			log.setsName(serverDetail.getName());
			log.setLog("删除"+serverDetail.getName()+"服务器");
			logService.addLog(log);
		}
	}
	
	/**
	 * 记录添加代理服务器日志
	 * @param returnValue
	 */
	@AfterReturning(pointcut = "execution(* com.server.server.service.IServerRelationService.addProxy(..))",
			returning = "returnValue")
	public void addProxy(Object returnValue){
		Proxy proxy = (Proxy) returnValue;
		Log log = this.generateLog();
		log.setsId(proxy.getsId());
		log.setProxyId(proxy.getId());
		log.setLog("添加"+proxy.getVhostName()+"代理服务器");
		logService.addLog(log);
	}
	
	/**
	 * 记录删除代理服务器日志
	 * @param point
	 */
	@AfterReturning("execution(* com.server.server.service.IServerRelationService.delProxyById(Long))")
	public void delProxy(JoinPoint point){
		Long id = (Long) point.getArgs()[0];
		Proxy proxy = serverRelationService.findProxy(id);
		Log log = this.generateLog();
		log.setsId(proxy.getsId());
		log.setProxyId(proxy.getId());
		log.setLog("删除"+ proxy.getVhostName() +"代理服务器");
		logService.addLog(log);
	}
	
	/**
	 * 记录修改代理服务器日志
	 * @param point
	 */
	@AfterReturning("execution(* com.server.server.service.IServerRelationService.updateProxy(..))")
	public void updateProxy(JoinPoint point){
		Proxy proxy = (Proxy) point.getArgs()[0];
		proxy = serverRelationService.findProxy(proxy.getId());
		Log log = this.generateLog();
		log.setsId(proxy.getsId());
		log.setProxyId(proxy.getId());
		log.setLog("修改" + proxy.getVhostName() + "代理服务器信息");
		logService.addLog(log);
	}
	
	/**
	 * 记录添加应用服务器日志
	 * @param returnValue
	 */
	@AfterReturning(pointcut = "execution(* com.server.server.service.IServerRelationService.addWebApp(..))",
			returning = "returnValue")
	public void addWebApp(Object returnValue){
		WebApp webApp = (WebApp) returnValue;
		Log log = this.generateLog();
		log.setsId(webApp.getsId());
		log.setWebAppId(webApp.getId());
		log.setLog("添加"+webApp.getAppName()+"应用服务器");
		logService.addLog(log);
	}
	
	/**
	 * 记录删除应用服务器日志
	 * @param point
	 */
	@AfterReturning("execution(* com.server.server.service.IServerRelationService.delWebAppById(Long))")
	public void delWebApp(JoinPoint point){
		Long id = (Long) point.getArgs()[0];
		WebApp webApp = serverRelationService.findWebApp(id);
		Log log = this.generateLog();
		log.setsId(webApp.getsId());
		log.setWebAppId(webApp.getId());
		log.setLog("删除"+webApp.getAppName()+"应用服务器");
		logService.addLog(log);
	}
	
	/**
	 * 记录修改应用服务器日志
	 * @param point
	 */
	@AfterReturning("execution(* com.server.server.service.IServerRelationService.updateWebApp(..))")
	public void updateWebApp(JoinPoint point){
		WebApp webApp = (WebApp) point.getArgs()[0];
		webApp = serverRelationService.findWebApp(webApp.getId());
		Log log = this.generateLog();
		log.setsId(webApp.getsId());
		log.setWebAppId(webApp.getId());
		log.setLog("修改"+webApp.getAppName()+"应用服务器");
		logService.addLog(log);
	}
	
	/**
	 * 记录添加数据库服务器日志
	 * @param returnValue
	 */
	@AfterReturning(pointcut = "execution(* com.server.server.service.IServerRelationService.addDatabase(..))",
			returning = "returnValue")
	public void addDatabase(Object returnValue){
		Database database = (Database) returnValue;
		Log log = this.generateLog();
		log.setsId(database.getsId());
		log.setDatabaseId(database.getId());
		log.setLog("添加"+database.getDbUser()+"数据库用户");
		logService.addLog(log);
	}
	
	/**
	 * 记录删除数据库服务器日志
	 * @param point
	 */
	@AfterReturning("execution(* com.server.server.service.IServerRelationService.delDatabaseById(Long))")
	public void delDatabase(JoinPoint point){
		Long id = (Long) point.getArgs()[0];
		Database database = serverRelationService.findDatabase(id);
		Log log = this.generateLog();
		log.setsId(database.getsId());
		log.setDatabaseId(database.getId());
		log.setLog("删除"+database.getDbUser()+"数据库用户");
		logService.addLog(log);
	}
	
	/**
	 * 记录修改数据库服务器日志
	 * @param point
	 */
	@AfterReturning("execution(* com.server.server.service.IServerRelationService.updateDatabase(..))")
	public void updateDatabase(JoinPoint point){
		Database database = (Database) point.getArgs()[0];
		database = serverRelationService.findDatabase(database.getId());
		Log log = this.generateLog();
		log.setsId(database.getsId());
		log.setDatabaseId(database.getId());
		log.setLog("修改"+database.getDbUser()+"数据库用户");
		logService.addLog(log);
	}
	
	/**
	 * 生成带有操作人的log实例
	 * @return
	 */
	public Log generateLog(){
		UserVo sessionUser = UserVo.getSessionUser(ServiceFacade.getSession());
		Log log = new Log();
		log.setCreateUid(sessionUser.getId());
		log.setCreateUser(sessionUser.getRealName());
		return log;
	}

}
