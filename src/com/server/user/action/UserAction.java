package com.server.user.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
 * 用户相关action
 * @author Dull Bird
 * @date 2015-7-7
 * 
 */
@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Resource(name = "user.service.UserService")
	private IUserService iuserService;
	
	/**
	 * 添加用户页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addUser")
	public String addUser(Model model){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "addUser");
		model.addAttribute("roleList",iuserService.queryRoleList());
		return "user/addUser";
	}
	
	/**
	 * 用户列表
	 * @param model
	 * @param user
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/userList",method={RequestMethod.GET,RequestMethod.POST})
	public String userList(Model model,@ModelAttribute("user") User user,Pagination pagination){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "userList");
		model.addAttribute("roleList",iuserService.queryRoleList());
		model.addAttribute(StaticParam.PAGE_BEAN,iuserService.queryUserList(pagination.getToPage(), 12, user.getRealName(), user.getTel(), user.getStatus(), user.getrId()));
		return "user/userList";
	}
	
	/**
	 * 我的信息
	 * @return
	 */
	@RequestMapping(value = "/myInfo",method={RequestMethod.GET,RequestMethod.POST})
	public String myInfo(Model model,HttpServletRequest request){
		//获取session的userId
		model.addAttribute("user",iuserService.getUser(2l));
		return "user/myInfo";
	}
	
	/**
	 * 修改密码
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updatePwd",method={RequestMethod.GET,RequestMethod.POST})
	public String updatePwd(Model model,HttpServletRequest request){
		return "user/updatePwd";
	}
	
}
