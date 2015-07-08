package com.server.server.action;

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
 * 服务器信息管理相关action
 * @author Dull Bird
 * @date 2015-7-8
 *
 */

@RequestMapping("/server")
@Controller
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
		return "server/addServer";
	}

}
