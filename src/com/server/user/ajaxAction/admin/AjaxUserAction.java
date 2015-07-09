package com.server.user.ajaxAction.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
 * 管理员的用户相关功能action
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */
@Controller("user.admin.AjaxUserAction")
@RequestMapping("/user/ajax/admin")
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
	
	/**
	 * 检查用户是否已经存在
	 * @param realName
	 * @return
	 */
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
	
	/**
	 * 用户详情
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/userDetail",method={RequestMethod.GET,RequestMethod.POST})
	public String userDetail(User user,Model model){
		UserVo userVo = iuserService.getUser(user.getId());
		model.addAttribute("user", userVo);
		return "user/admin/userDetail";
	}
	
	/**
	 * 重置密码（默认重置密码为dg11185）
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/resetPwd",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult resetPwd(User user){
		int res = iuserService.updatePwd("dg11185", user.getId());
		if(res > 0){
			return new JsonResult(true);
		}
		return new JsonResult(false,"请勿非法使用系统");
	}
	
	/**
	 * 删除用户（状态值置0），此操作页面不可恢复
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/deleteUser",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult deleteUser(User user){
		int res = iuserService.deleteUser(user.getId());
		if(res > 0){
			return new JsonResult(true);
		}
		return new JsonResult(false,"请勿非法使用系统");
	}

}
