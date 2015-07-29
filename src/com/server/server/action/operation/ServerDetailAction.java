package com.server.server.action.operation;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.server.base.StaticParam;
import com.server.entity.ServerDetail;
import com.server.server.service.IServerDetailService;
import com.server.user.service.IUserService;
import com.server.utils.page.Pagination;
import com.server.vo.server.ServerDetailVo;
import com.server.vo.user.UserVo;

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
	@RequestMapping(value = "/addServer",method={RequestMethod.GET,RequestMethod.POST})
	public String addServer(Model model,ServerDetail server){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "addServer");
		//查询出所有服务器类型
		model.addAttribute("serverType",iserverDetailService.queryServerTypeList());
		//查询出角色为运维人员，观察者的状态正常的用户
		model.addAttribute("user",iuserService.queryAddServerUser());
		return "server/operation/addServer";
	}
	
	/**
	 * 我的服务器
	 * @param model
	 * @param pagination
	 * @param stId		服务器类型
	 * @return
	 */
	@RequestMapping(value = "/myServerList",method={RequestMethod.GET,RequestMethod.POST})
	public String serverList(Model model,Long stId,Pagination pagination,
			HttpSession session){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "myServerList");
		//用于回显，基础类型没有保留空的构造方法，因此使用@ModelAttribute回报错
		model.addAttribute("stId", stId);
		//查询出所有服务器类型
		model.addAttribute("serverType",iserverDetailService.queryServerTypeList());
		//获取seesion的用户信息
		UserVo sessionUser = UserVo.getSessionUser(session);
		model.addAttribute(StaticParam.PAGE_BEAN,iserverDetailService.myServerList(1, 12, stId, sessionUser.getId()));
		return "server/operation/myServerList";
	}

}
