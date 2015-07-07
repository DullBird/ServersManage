package com.server.ajax.user;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.entity.User;
import com.server.user.service.IUserService;
import com.server.vo.JsonResult;


/**
 * 用户相关action
 * @author Dull Bird
 * @date 2015-7-7
 * 
 */
@Controller
@RequestMapping("/ajax")
public class AjaxUserAction {
	
	@Resource(name = "user.service.UserService")
	private IUserService iuserService;
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/addUser",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult addUser(@Valid User user,BindingResult br){
		boolean isSuccess = false;
		if(br.hasErrors()){
			return new JsonResult(isSuccess,null);
		}
		int res = iuserService.addUser(user);
		if(res > 0){
			isSuccess = true;
		}
		return new JsonResult(isSuccess,null);
	}
	
	@RequestMapping(value = "/checkUserExist",method={RequestMethod.POST})
	@ResponseBody
	public String checkUserExist(String realName){
		String res = "true";
		if(iuserService.checkUserExist(realName)){
			//若已经存在，则不能通过验证，故返回false
			res = "false";
		}
		return res;
	}

}
