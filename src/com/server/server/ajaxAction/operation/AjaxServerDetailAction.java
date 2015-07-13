package com.server.server.ajaxAction.operation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.entity.ServerDetail;
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
@Controller("server.operation.AjaxServerDetailAction")
public class AjaxServerDetailAction {
	
	@Resource(name = "server.service.ServerDetailService")
	private IServerDetailService iserverDetailService;
	
	/**
	 * 新增服务器
	 * @return
	 */
	@RequestMapping(value = "/addServer",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult addServer(ServerDetail server,
			Long[] stidList,Long[] userIdList){
		//获取seesion的用户信息
		server.setCreateUid(1l);
		server.setCreateUser("赖永钊");
		iserverDetailService.addServer(server,stidList,userIdList);
		return new JsonResult(true);
	}

}
