package com.server.user.action.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.server.base.StaticParam;
import com.server.entity.User;
import com.server.user.service.IOnlineUserService;
import com.server.user.service.IUserService;
import com.server.utils.page.Pagination;
import com.server.vo.user.UserVo;

/**
 * 管理员的用户相关功能action
 * @author Dull Bird
 * @date 2015-7-9
 * 
 */
@Controller("user.admin.UserAction")
@RequestMapping("/user/admin")
public class UserAction {
	
	@Resource(name = "user.service.UserService")
	private IUserService iuserService;
	
	@Resource(name = "user.service.OnlineUserService")
	private IOnlineUserService onlineUserService;
	
	/**
	 * 添加用户页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addUser")
	public String addUser(Model model){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "addUser");
		model.addAttribute("roleList",iuserService.queryRoleList());
		return "user/admin/addUser";
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
		return "user/admin/userList";
	}
	
	/**
	 * 在线用户列表
	 * @param model
	 * @param user
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/onlineUserList",method={RequestMethod.GET,RequestMethod.POST})
	public String onlineUserList(Model model,@ModelAttribute("user") User user,
			Pagination<UserVo> pagination){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "onlineUserList");
		model.addAttribute(StaticParam.PAGE_BEAN,onlineUserService.queryOnlineUser(pagination.getToPage(), 12));
		return "user/admin/onlineUserList";
	}
	
}
