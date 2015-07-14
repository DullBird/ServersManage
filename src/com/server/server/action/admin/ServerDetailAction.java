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
	 * @param server
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/allServerList",method={RequestMethod.GET,RequestMethod.POST})
	public String serverList(Model model, Long stId,Pagination pagination){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "allServerList");
		//查询出所有服务器类型
		model.addAttribute("serverType",iserverDetailService.queryServerTypeList());
		model.addAttribute(StaticParam.PAGE_BEAN,iserverDetailService.allServerList(1, 12, stId));
		return "server/admin/myServerList";
	}

}
