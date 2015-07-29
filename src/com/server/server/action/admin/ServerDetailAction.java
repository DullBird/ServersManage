package com.server.server.action.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.server.base.StaticParam;
import com.server.entity.ServerDetail;
import com.server.server.service.IServerDetailService;
import com.server.user.service.IUserService;
import com.server.utils.page.Pagination;

/**
 * 
 * 运维人员的服务器管理相关功能action
 * @author Dull Bird
 * @date 2015-7-14
 *
 */
@RequestMapping("/server/admin")
@Controller("server.admin.ServerDetailAction")
public class ServerDetailAction {
	
	@Resource(name = "server.service.ServerDetailService")
	private IServerDetailService iserverDetailService;
	
	/**
	 * 服务器列表
	 * @param model
	 * @param pagination
	 * @param stId		服务器类型
	 * @param status	服务器状态
	 * @return
	 */
	@RequestMapping(value = "/allServerList",method={RequestMethod.GET,RequestMethod.POST})
	public String serverList(Model model,Long stId,Integer status,Pagination pagination){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "allServerList");
		//用于回显，基础类型没有保留空的构造方法，因此使用@ModelAttribute回报错
		model.addAttribute("stId", stId);
		model.addAttribute("status",status);
		//查询出所有服务器类型
		model.addAttribute("serverType",iserverDetailService.queryServerTypeList());
		model.addAttribute(StaticParam.PAGE_BEAN,iserverDetailService.allServerList(pagination.getToPage(), 12, stId,status));
		return "server/admin/allServerList";
	}

}
