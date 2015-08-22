package com.server.aop;

import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.server.entity.Log;
import com.server.entity.User;
import com.server.log.service.ILogService;
import com.server.user.service.IUserService;
import com.server.utils.ServiceFacade;
import com.server.vo.user.UserVo;

/**
 * 记录用户模块的日志aop
 * @author Dull Bird
 * @date 2015-8-21
 */
@Aspect
@Component
public class UserLogAop {
	
	@Resource(name = "user.service.UserService")
	private IUserService userService;
	
	@Resource(name = "log.service.LogService")
	private ILogService logService;

	/**
	 * 记录添加用户的日志
	 * @param point
	 */
	@After("execution(* com.server.user.service.*.addUser(..))")
	public void addUser(JoinPoint point) {
		Log log = this.generateLog();
		Object[] args = point.getArgs();
		User user = (User) args[0];
		List<UserVo> userList =  userService.queryUserList(1, 2, user.getRealName(), null, null, null).getObjLists();
		if(userList.size() > 0){
			UserVo userVo = userList.get(0);
			log.setUserId(userVo.getId());
			log.setRealName(userVo.getRealName());
			log.setLog("添加"+userVo.getRealName()+userVo.getRoleName()+"用户");
			logService.addLog(log);
		}
	}

	/**
	 * 记录删除用户的日志
	 * @param point
	 */
	@After("execution(* com.server.user.service.*.deleteUser(..))")
	public void delUser(JoinPoint point) {
		//此次操作的人
		Log log = this.generateLog();
		Object[] args = point.getArgs();
		Long userId = (Long) args[0];
		//查询出用户信息
		UserVo user = userService.getUser(userId);
		log.setUserId(user.getId());
		log.setRealName(user.getRealName());
		log.setLog("删除"+ user.getRealName() +"用户");
		logService.addLog(log);
	}

	/**
	 * 记录初始化密码的日志
	 * @param point
	 */
	@After("execution(* com.server.user.service.*.updatePwd(String,Long))")
	public void resetPwd(JoinPoint point) {
		Log log = this.generateLog();
		//根据id查询出需要重置密码的用户
		Object[] args = point.getArgs();
		Long userId = (Long) args[1];
		UserVo user = userService.getUser(userId);
		log.setUserId(user.getId());
		log.setRealName(user.getRealName());
		log.setLog("重置"+user.getRealName()+"的密码，默认密码为dg11185");
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
