package com.server.demo.action;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.server.base.StaticParam;
import com.server.demo.service.IDemoService;
import com.server.entity.Logs;
import com.server.utils.page.Pagination;
import com.server.vo.JsonResult;

@Controller
@RequestMapping("/demo")
public class DemoAction {
	
	private IDemoService idemoService;
	
	@Resource(name = "demo.server.DemoService")
	public void setIdemoService(IDemoService idemoService) {
		this.idemoService = idemoService;
	}

	@RequestMapping(value="/helloworld",method=RequestMethod.GET)
	public String helloWorld(){
		System.out.println("hello world!!!");
		return "demo/helloworld";
	}
	
	/**
	 * 带条件查询
	 * @return
	 */
	@RequestMapping(value="queryDemo",method={RequestMethod.GET,RequestMethod.POST})
	public String query(@ModelAttribute("trueName") String trueName,Model model){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "queryDemo");
		model.addAttribute("user", idemoService.queryDemo(trueName));
		return "demo/queryDemo";
	}
	
	/**
	 * 带条件的分页查询
	 * @return
	 */
	@RequestMapping(value="pageDemo",method={RequestMethod.GET,RequestMethod.POST})
	public String queryForPage(Pagination pagination,Model model){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "pageDemo");
		model.addAttribute(StaticParam.PAGE_BEAN, idemoService.pageDemo(pagination.getToPage(), 12));
		return "demo/pageDemo";
	}
	
	/**
	 * 返回添加的表单页面
	 * @return
	 */
	@RequestMapping(value="addDemo",method={RequestMethod.GET,RequestMethod.POST})
	public String add(Model model){
		model.addAttribute(StaticParam.HEIGHT_LIGHT, "addDemo");
		return "demo/addDemo";
	}
	
	/**
	 * 提交表单，返回json数据
	 * 使用@ResponseBody标签，把返回的对象写到页面上
	 * 使用@Valid标签参数验证
	 * @param logs
	 * @return
	 */
	@RequestMapping(value="add",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JsonResult addDB(@Valid Logs logs,BindingResult br){
		boolean isSuccess = false;
		if(br.hasErrors()){
			return new JsonResult(isSuccess,null);
		}
		int res = idemoService.insertDemo(logs);
		if(res > 0){
			isSuccess = true;
		}
		return new JsonResult(isSuccess,null);
	}
	
	/**
	 * 重定向到addDemo方法
	 * @param attr	用于重定向时传递参数
	 * @return
	 */
	@RequestMapping(value="redirectDemo",method={RequestMethod.GET,RequestMethod.POST})
	public String redirectDemo(String parm,RedirectAttributes attr){
		attr.addAttribute("parm", parm);
		return "redirect:/demo/addDemo";
	}

}
