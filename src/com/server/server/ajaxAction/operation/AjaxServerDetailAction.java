package com.server.server.ajaxAction.operation;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.entity.Database;
import com.server.entity.Proxy;
import com.server.entity.ServerDetail;
import com.server.entity.WebApp;
import com.server.server.service.IServerDetailService;
import com.server.server.service.IServerRelationService;
import com.server.user.service.IUserServerService;
import com.server.user.service.IUserService;
import com.server.vo.JsonResult;
import com.server.vo.server.ServerCreateUserVo;
import com.server.vo.user.UserServerVo;
import com.server.vo.user.UserVo;

/**
 * 
 * 运维人员的服务器管理相关功能的ajaxaction
 * @author Dull Bird
 * @date 2015-7-9
 *
 */
@RequestMapping("/server/ajax/operation")
@Controller("server.operation.AjaxServerDetailAction")
public class AjaxServerDetailAction {
	
	@Resource(name = "server.service.ServerDetailService")
	private IServerDetailService iserverDetailService;
	
	@Resource(name = "user.service.UserService")
	private IUserService iuserService;
	
	@Resource(name = "user.service.UserServerService")
	private IUserServerService iuserServerService;
	
	@Resource(name = "server.service.ServerRelationService")
	private IServerRelationService iserverRelationService;
	
	/**
	 * 新增服务器
	 * @param server
	 * @param stidList		服务器类型id列表
	 * @param userIdList	可管理人员id列表
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addServer",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult addServer(ServerDetail server,Long[] stidList,
			Long[] userIdList,HttpSession session){
		//获取seesion的用户信息
		UserVo sessionUser = UserVo.getSessionUser(session);
		server.setCreateUid(sessionUser.getId());
		server.setCreateUser(sessionUser.getRealName());
		iserverDetailService.addServer(server,stidList,userIdList);
		return new JsonResult(true);
	}
	
	/**
	 * 服务器详情信息
	 * @param sId	服务器id
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/serverDetail",method={RequestMethod.POST})
	public String serverDetail(Long sId,HttpSession session,Model model){
		//获取seesion的用户信息
		UserVo sessionUser = UserVo.getSessionUser(session);
		model.addAttribute("server", iserverDetailService.serverDetail(sId, sessionUser.getId(),1));
		return "/server/operation/serverDetail";
	}
	
	/**
	 * 更新服务器返回的页面
	 * @param sId	服务器id
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateServer",method={RequestMethod.POST})
	public String updateServer(Long sId,HttpSession session,Model model){
		//获取seesion的用户信息
		UserVo sessionUser = UserVo.getSessionUser(session);
		model.addAttribute("server", iserverDetailService.serverDetail(sId, sessionUser.getId(),1));
		//查询出所有服务器类型
		model.addAttribute("serverType",iserverDetailService.queryServerTypeList());
		//查询出角色为运维人员，观察者的状态正常的用户
		model.addAttribute("user",iuserService.queryAddServerUser());
		return "/server/operation/updateServer";
	}
	
	/**
	 * 更新服务器基本信息
	 * @param server
	 * @param stidList		服务器类型id列表
	 * @param userIdList	可管理人员id列表
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/update",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult update(ServerDetail server,Long[] stidList,
			Long[] userIdList,HttpSession session,HttpServletRequest request){
		//获取seesion的用户信息
		UserVo sessionUser = UserVo.getSessionUser(session);
		return iserverDetailService.updateServer(server, stidList, userIdList, sessionUser);
	}
	
	/**
	 * 删除服务器
	 * @param sId 	服务器id
	 * @return
	 */
	@RequestMapping(value = "/delServer",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult delServer(Long sId,HttpSession session){
		//获取seesion的用户信息
		UserVo sessionUser = UserVo.getSessionUser(session);
		return iserverDetailService.delServer(sId,sessionUser.getId());
	}
	
	/**
	 * 查询出可以转让的所有运维人员
	 * @return
	 */
	@RequestMapping(value = "/operationList",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JsonResult<List<UserServerVo>> operationList(Long sId){
		return new JsonResult<List<UserServerVo>>(true,iuserServerService.queryOperationBySid(sId));
	}
	
	/**
	 * 转让服务器属主
	 * @param id		服务器id
	 * @param userId	用户id
	 * @param realName	用户真实姓名
	 * @return
	 */
	@RequestMapping(value = "/updateCreateUser",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult updateCreateUser(@Valid ServerCreateUserVo server,
			BindingResult br){
		if(br.hasErrors()){
			return new JsonResult<Proxy>(false,"错误的参数");
		}
		return iserverDetailService.updateServerCreateUser(server.getsId(), server.getUserId());
	}
	
	/**
	 * 添加代理服务器
	 * @param proxy
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addProxy",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult<Proxy> addProxy(@Valid Proxy proxy,HttpSession session
			,BindingResult br){
		if(br.hasErrors()){
			return new JsonResult<Proxy>(false,"错误的参数");
		}
		//获取seesion的用户信息
		UserVo sessionUser = UserVo.getSessionUser(session);
		proxy = iserverRelationService.addProxy(proxy,sessionUser.getId());
		return new JsonResult<Proxy>(true, proxy);
	}
	
	/**
	 * 删除代理服务器
	 * @param proxy
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/delProxy",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult delProxy(Proxy proxy){
		iserverRelationService.delProxyById(proxy.getId());
		return new JsonResult(true);
	}
	
	/**
	 * 编辑代理服务器
	 * @param proxy
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/editProxy",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult<Proxy> editProxy(@Valid Proxy proxy,BindingResult br){
		if(br.hasErrors()){
			return new JsonResult<Proxy>(false,"错误的参数");
		}
		iserverRelationService.updateProxy(proxy);
		return new JsonResult<Proxy>(true,proxy);
	}
	
	/**
	 * 添加应用服务器
	 * @param webApp
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addWebApp",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult<WebApp> addWebApp(@Valid WebApp webApp,HttpSession session
			,BindingResult br){
		if(br.hasErrors()){
			return new JsonResult<WebApp>(false,"错误的参数");
		}
		//获取seesion的用户信息
		UserVo sessionUser = UserVo.getSessionUser(session);
		webApp = iserverRelationService.addWebApp(webApp, sessionUser.getId());
		return new JsonResult<WebApp>(true, webApp);
	}
	
	/**
	 * 删除应用服务器
	 * @param webApp
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/delWebApp",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult delWebApp(WebApp webApp){
		iserverRelationService.delWebAppById(webApp.getId());
		return new JsonResult(true);
	}
	
	/**
	 * 编辑应用服务器
	 * @param webApp
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/editWebApp",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult<WebApp> editWebApp(@Valid WebApp webApp,BindingResult br){
		if(br.hasErrors()){
			return new JsonResult<WebApp>(false,"错误的参数");
		}
		iserverRelationService.updateWebApp(webApp);
		return new JsonResult<WebApp>(true,webApp);
	}
	
	/**
	 * 添加数据库服务器
	 * @param database
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addDatabase",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult<Database> addDatabase(@Valid Database database,HttpSession session
			,BindingResult br){
		if(br.hasErrors()){
			return new JsonResult<Database>(false,"错误的参数");
		}
		//获取seesion的用户信息
		UserVo sessionUser = UserVo.getSessionUser(session);
		database = iserverRelationService.addDatabase(database, sessionUser.getId());
		return new JsonResult<Database>(true, database);
	}
	
	/**
	 * 删除数据库服务器
	 * @param database
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/delDatabase",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult delDatabase(Database database){
		iserverRelationService.delDatabaseById(database.getId());
		return new JsonResult(true);
	}
	
	/**
	 * 编辑数据库服务器
	 * @param database
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/editDatabase",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult<Database> editDatabase(@Valid Database database,BindingResult br){
		if(br.hasErrors()){
			return new JsonResult<Database>(false,"错误的参数");
		}
		iserverRelationService.updateDatabase(database);
		return new JsonResult<Database>(true,database);
	}
	
}
