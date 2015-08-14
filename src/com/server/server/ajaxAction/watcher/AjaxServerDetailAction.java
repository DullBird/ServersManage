package com.server.server.ajaxAction.watcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.server.server.service.IServerDetailService;
import com.server.vo.user.UserVo;

/**
 * 
 * 观察者查看服务器相关功能的ajaxAction
 * @author Dull Bird
 * @date 2015-8-14
 *
 */

@RequestMapping("/server/ajax/watcher")
@Controller("server.watcher.AjaxServerDetailAction")
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
	public String serverDetail(Long sId,Model model,HttpSession session){
		//获取seesion的用户信息
		UserVo sessionUser = UserVo.getSessionUser(session);
		model.addAttribute("server", iserverDetailService.serverDetail(sId, sessionUser.getId(),1));
		return "/server/watcher/serverDetail";
	}

}
