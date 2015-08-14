package com.server.server.ajaxAction.admin;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.server.server.service.IServerDetailService;

/**
 * 
 * 管理员查看服务器相关功能的ajaxAction
 * @author Dull Bird
 * @date 2015-8-14
 *
 */

@RequestMapping("/server/ajax/admin")
@Controller("server.admin.AjaxServerDetailAction")
public class AjaxServerDetailAction {
	
	@Resource(name = "server.service.ServerDetailService")
	private IServerDetailService iserverDetailService;
	
	/**
	 * 服务器详情信息
	 * @param sId	服务器id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/serverDetail",method={RequestMethod.POST})
	public String serverDetail(Long sId,Model model){
		model.addAttribute("server", iserverDetailService.serverDetail(sId, null,null));
		return "/server/admin/serverDetail";
	}

}
