package com.server.common.action;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.server.user.service.IUserService;
import com.server.vo.user.LoginUserVo;
import com.server.vo.user.UserVo;

/**
 * 全站通用（无条件限制）action
 * 
 * @author Dull Bird
 * @date 2015-7-15
 * 
 */

@Controller("common.CommonAction")
public class CommonAction {
	
	@Resource(name = "user.service.UserService")
	private IUserService userService;

	@Resource(name = "captchaProducer")
	private Producer captchaProducer;		//验证码生成器

	/**
	 * 登录页面
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.GET})
	public String login() {
		return "login";
	}

	/**
	 * 生成验证码，返回图片
	 * @param session
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/verifyCode")
	public void getKaptchaImage(HttpSession session,
			HttpServletResponse response) throws Exception {
		//生成验证码并保存在session里
		String capText = captchaProducer.createText();
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		// session里面的验证码
		//String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		//System.out.println("验证码: " + code );
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control","no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}
	
	
	/*@RequestMapping("/checkValidateCode")
	public String checkValidateCode(HttpServletRequest request){
		HttpSession session = request.getSession();
		// session里面的验证码
		String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		System.out.println("验证码: " + code );
		return null;
	}*/
	
}
