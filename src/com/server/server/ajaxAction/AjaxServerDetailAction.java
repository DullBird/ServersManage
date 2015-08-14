package com.server.server.ajaxAction;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.entity.Database;
import com.server.entity.Proxy;
import com.server.entity.WebApp;
import com.server.server.service.IServerRelationService;
import com.server.vo.JsonResult;

/**
 * 
 * 通用的服务器管理相关功能的ajaxaction
 * @author Dull Bird
 * @date 2015-8-11
 *
 */
@RequestMapping("/server/ajax")
@Controller("server.AjaxServerDetailAction")
public class AjaxServerDetailAction {
	
	@Resource(name = "server.service.ServerRelationService")
	private IServerRelationService serverRelationService;
	
	/**
	 * 根据id查询出代理服务器的详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findProxy",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult<Proxy> findProxy(Long id){
		Proxy proxy = serverRelationService.findProxy(id);
		return new JsonResult<Proxy>(true, proxy);
	}
	
	/**
	 * 根据id查询出应用服务器的详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findWebApp",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult<WebApp> findWebApp(Long id){
		WebApp webApp = serverRelationService.findWebApp(id);
		return new JsonResult<WebApp>(true, webApp);
	}
	
	/**
	 * 根据id查询出数据库服务器的详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findDatabase",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult<Database> findDatabase(Long id){
		Database database = serverRelationService.findDatabase(id);
		return new JsonResult<Database>(true, database);
	}

}
