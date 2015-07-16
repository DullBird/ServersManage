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
		boolean isSuccess = false;
		if(br.hasErrors()){
			return new JsonResult(isSuccess,"参数错误");
		}
		//判断验证码是否正确
		String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(!code.equals(loginUser.getVerifyCode())){
			return new JsonResult(isSuccess,"验证码错误");
		}
		//判断用户是否存在和密码是否正确
		UserVo user = userService.queryUserByUserName(loginUser.getUserName());
		if(null == user){
			//用户不存在，也提示用户名或密码错误
			return new JsonResult(isSuccess,"用户名或密码错误");
		}
		if(!EncryptUitls.MD5Digest(loginUser.getPassWord()).equals(user.getPassWord())){
			//密码错误
			return new JsonResult(isSuccess,"用户名或密码错误");
		}
		//验证通过，保存用户信息到session，并返回成功
		isSuccess = true;
		User sessionUser = new User();
		sessionUser.setUserName(user.getUserName());
		sessionUser.setRealName(user.getRealName());
		sessionUser.setTel(user.getTel());
		session.setAttribute(StaticParam.SESSION_USER, sessionUser);
		return new JsonResult(isSuccess,null);
	}

}
