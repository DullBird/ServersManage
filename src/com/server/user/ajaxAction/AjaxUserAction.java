package com.server.user.ajaxAction;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.entity.User;
import com.server.user.service.IUserService;
import com.server.vo.JsonResult;
import com.server.vo.user.UserVo;


/**
 * 通用的用户相关功能action
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */
@Controller("user.AjaxUserAction")
@RequestMapping("/user/ajax")
public class AjaxUserAction {
	
	@Resource(name = "user.service.UserService")
	private IUserService iuserService;
	
	
	/**
	 * 修改密码
	 * @param oldPwd
	 * @param newPwd
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updatePwd",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult updatePwd(String oldPwd,String newPwd,
		HttpSession session){
		//获取session的userId
		UserVo sessionUser = UserVo.getSessionUser(session);
		return iuserService.updatePwd(oldPwd,newPwd, sessionUser.getId());
	}
	
}
