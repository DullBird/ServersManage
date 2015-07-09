package com.server.server.action.operation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.server.base.StaticParam;
import com.server.entity.ServerDetail;
import com.server.server.service.IServerDetailService;

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
	
	/**
	 * 增加服务器
	 * @param model
	 * @param server
	 * @return
	 */
	@RequestMapping(value = "/addServer",method={RequestMethod.GET})
	public String addServer(Model model,ServerDetail server){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "addServer");
		model.addAttribute("serverType",iserverDetailService.queryServerTypeList());
		return "server/operation/addServer";
	}

}
