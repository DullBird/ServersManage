package com.server.server.action.operation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.server.base.StaticParam;
import com.server.entity.ServerDetail;
import com.server.server.service.IServerDetailService;
import com.server.user.service.IUserService;
import com.server.utils.page.Pagination;

/**
 * 
 * 运维人员的服务器管理相关功能action
 * @author Dull Bird
 * @date 2015-7-9
 *
 */
@RequestMapping("/server/operation")
@Controller("server.operation.ServerDetailAction")
public class ServerDetailAction {
	
	@Resource(name = "server.service.ServerDetailService")
	private IServerDetailService iserverDetailService;
	
	@Resource(name = "user.service.UserService")
	private IUserService iuserService;
	
	/**
	 * 增加服务器
	 * @param model
	 * @param server
	 * @return
	 */
	@RequestMapping(value = "/addServer",method={RequestMethod.GET})
	public String addServer(Model model,ServerDetail server){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "addServer");
		//查询出所有服务器类型
		model.addAttribute("serverType",iserverDetailService.queryServerTypeList());
		//查询出角色为运维人员，观察者的状态正常的用户
		model.addAttribute("user",iuserService.queryAddServerUser());
		return "server/operation/addServer";
	}
	
	/**
	 * 服务器列表
	 * @param model
	 * @param server
	 * @param pagination
	 * @return
	 */
	public String serverList(Model model,ServerDetail server,Pagination pagination){
		return null;
	}

}
