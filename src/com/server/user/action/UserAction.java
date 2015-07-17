package com.server.user.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.server.base.StaticParam;
import com.server.entity.User;
import com.server.user.service.IUserService;
import com.server.utils.page.Pagination;
import com.server.vo.user.UserVo;

/**
 * 通用的用户相关功能action
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */
@Controller("user.UserAction")
@RequestMapping("/user")
public class UserAction {
	
	@Resource(name = "user.service.UserService")
	private IUserService iuserService;
	
	/**
	 * 我的信息
	 * @return
	 */
	@RequestMapping(value = "/myInfo",method={RequestMethod.GET})
	public String myInfo(Model model,HttpSession session){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "myInfo");
		//获取session的userId
		UserVo sessionUser = UserVo.getSessionUser(session);
		model.addAttribute("user",iuserService.getUser(sessionUser.getId()));
		return "user/myInfo";
	}
	
	/**
	 * 修改密码
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updatePwd",method={RequestMethod.GET})
	public String updatePwd(Model model,HttpServletRequest request){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "updatePwd");
		return "user/updatePwd";
	}
	
	/**
	 * 后台欢迎页面
	 * @return
	 */
	@RequestMapping(value = "/welcome",method={RequestMethod.GET})
	public String welcome(){
		return "welcome";
	}
	
}
