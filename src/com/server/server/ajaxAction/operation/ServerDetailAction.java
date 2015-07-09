package com.server.server.ajaxAction.operation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.server.service.IServerDetailService;
import com.server.vo.JsonResult;

/**
 * 
 * 运维人员的服务器管理相关功能的ajaxaction
 * @author Dull Bird
 * @date 2015-7-9
 *
 */
@RequestMapping("/server/ajax/operation")
@Controller("server.operation.ServerDetailAction")
public class ServerDetailAction {
	
	@Resource(name = "server.service.ServerDetailService")
	private IServerDetailService iserverDetailService;
	
	/**
	 * 新增服务器
	 * @return
	 */
	@RequestMapping(value = "/addServer",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult addServer(){
		iserverDetailService.addServer(null);
		return null;
	}

}
