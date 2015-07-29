package com.server.server.ajaxAction.operation;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.entity.Proxy;
import com.server.entity.ServerDetail;
import com.server.server.service.IServerDetailService;
import com.server.server.service.IServerRelationService;
import com.server.user.service.IUserService;
import com.server.vo.JsonResult;
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
			Long[] userIdList,HttpSession session){
		//获取seesion的用户信息
		UserVo sessionUser = UserVo.getSessionUser(session);
		return iserverDetailService.updateServer(server, stidList, userIdList, sessionUser);
	}
	
	/**
	 * 添加代理服务器
	 * @param proxy
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addProxy",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult addProxy(Proxy proxy,HttpSession session){
		//获取seesion的用户信息
		UserVo sessionUser = UserVo.getSessionUser(session);
		iserverRelationService.addProxy(proxy,sessionUser.getId());
		return new JsonResult(true);
	}
}
