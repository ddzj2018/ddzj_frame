package com.mgr.learn.web.admin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgr.learn.api.IUsersService;
/**
 * Admin控制器
 * @author zhouchangwei
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	private static Logger log = Logger.getLogger(AdminController.class);
	@Autowired(required = false)
	private IUsersService usersServiceImpl;
	/**
	 * 登录页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login")
	public String login(Model model) {
		log.info("==login page");
		model.addAttribute("info", "info");
		return "/admin/login";
	}
	/**
	 * 登录动作
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doLogin")
	public @ResponseBody String doLogin(Model model) {
		return "doLogin";
	}
	/**
	 * 退出
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public @ResponseBody String logout(Model model) {
		return "logout";
	}
	@RequestMapping(value = "index")
	public String index(Model model) {
		log.info("==index page");
		model.addAttribute("info", "info");
		return "/admin/index";
	}
	
	
}
