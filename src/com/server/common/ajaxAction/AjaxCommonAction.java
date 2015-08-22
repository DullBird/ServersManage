package com.server.common.ajaxAction;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.server.base.StaticParam;
import com.server.entity.User;
import com.server.user.service.IUserService;
import com.server.utils.EncryptUitls;
import com.server.vo.JsonResult;
import com.server.vo.user.LoginUserVo;
import com.server.vo.user.UserVo;

/**
 * 全站通用（无条件限制）的ajax action
 * 
 * @author Dull Bird
 * @date 2015-7-16
 * 
 */
@Controller("common.AjaxCommonAction")
public class AjaxCommonAction {
	
	@Resource(name = "user.service.UserService")
	private IUserService userService;
	
	/**
	 * ajax登录
	 * @param user
	 * @param br
	 * @return
	 */
	@RequestMapping(value = "/ajaxLogin",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult login(@Valid LoginUserVo loginUser,BindingResult br,HttpSession session){
		if(br.hasErrors()){
			return new JsonResult(false,"参数错误");
		}
		return userService.login(loginUser, session);
	}
	
}
